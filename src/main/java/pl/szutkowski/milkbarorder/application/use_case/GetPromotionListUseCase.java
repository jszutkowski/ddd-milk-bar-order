package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.GetPromotionListRequest;
import pl.szutkowski.milkbarorder.application.response.GetPromotionListResponse;
import pl.szutkowski.milkbarorder.domain.order.Order;
import pl.szutkowski.milkbarorder.domain.order.OrderId;
import pl.szutkowski.milkbarorder.domain.order.OrderNotFoundException;
import pl.szutkowski.milkbarorder.domain.order.OrderRepository;
import pl.szutkowski.milkbarorder.domain.promotion.Promotion;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

import java.util.List;

public class GetPromotionListUseCase {

    private OrderRepository orderRepository;
    private PromotionAdapter promotionAdapter;

    public GetPromotionListUseCase(OrderRepository orderRepository, PromotionAdapter promotionAdapter) {
        this.orderRepository = orderRepository;
        this.promotionAdapter = promotionAdapter;
    }

    public GetPromotionListResponse execute(GetPromotionListRequest request) throws OrderNotFoundException {

        Order order = orderRepository.findIncompleteOrder(new OrderId(request.getOrderId()));
        List<Promotion> promotions = promotionAdapter.getPromotions();

        return new GetPromotionListResponse(order, promotions);
    }
}
