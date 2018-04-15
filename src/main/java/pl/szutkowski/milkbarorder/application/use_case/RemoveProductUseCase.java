package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.AddProductRequest;
import pl.szutkowski.milkbarorder.domain.order.*;
import pl.szutkowski.milkbarorder.domain.product.ProductId;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

public class RemoveProductUseCase {

    private final OrderRepository orderRepository;
    private final RemoveProductService removeProductService;

    public RemoveProductUseCase(OrderRepository orderRepository, RemoveProductService removeProductService) {

        this.orderRepository = orderRepository;
        this.removeProductService = removeProductService;
    }

    public void execute(AddProductRequest request) throws OrderNotFoundException {

        OrderId orderId = new OrderId(request.getOrderId());
        Order order = orderRepository.findIncompleteOrder(orderId);
        removeProductService.removeProduct(order, new ProductId(request.getProductId()));
        orderRepository.save(order);
    }
}
