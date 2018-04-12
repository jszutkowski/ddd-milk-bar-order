package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.GetPromotionProductsRequest;
import pl.szutkowski.milkbarorder.application.response.GetPromotionProductsResponse;
import pl.szutkowski.milkbarorder.domain.order.Order;
import pl.szutkowski.milkbarorder.domain.order.OrderId;
import pl.szutkowski.milkbarorder.domain.order.OrderNotFoundException;
import pl.szutkowski.milkbarorder.domain.order.OrderRepository;
import pl.szutkowski.milkbarorder.domain.product.Product;
import pl.szutkowski.milkbarorder.domain.product.ProductAdapter;
import pl.szutkowski.milkbarorder.domain.promotion.*;

import java.util.List;

public class GetPromotionProductsUseCase {

    private OrderRepository orderRepository;
    private PromotionAdapter promotionAdapter;
    private ProductAdapter productAdapter;

    public GetPromotionProductsUseCase(OrderRepository orderRepository, PromotionAdapter promotionAdapter, ProductAdapter productAdapter) {
        this.orderRepository = orderRepository;
        this.promotionAdapter = promotionAdapter;
        this.productAdapter = productAdapter;
    }

    public GetPromotionProductsResponse execute(GetPromotionProductsRequest request) throws OrderNotFoundException, PromotionNotFoundException, PromotionNotAvailableException {
        Order order = orderRepository.findIncompleteOrder(new OrderId(request.getOrderId()));
        Promotion promotion = promotionAdapter.getPromotion(new PromotionId(request.getPromotionId()));

        if (!promotion.isAvailable(order)) {
            throw new PromotionNotAvailableException();
        }

        List<Product> products = productAdapter.getPromotionProducts(promotion.id());
        return new GetPromotionProductsResponse(products);
    }
}
