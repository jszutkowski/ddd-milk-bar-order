package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.AssignPromotionRequest;
import pl.szutkowski.milkbarorder.domain.order.*;
import pl.szutkowski.milkbarorder.domain.promotion.*;

public class AssignPromotionUseCase {

    private PromotionAdapter promotionAdapter;
    private OrderRepository orderRepository;

    public AssignPromotionUseCase(PromotionAdapter promotionAdapter,
                                  OrderRepository orderRepository) {
        this.promotionAdapter = promotionAdapter;
        this.orderRepository = orderRepository;
    }

    public void execute(AssignPromotionRequest request) throws PromotionNotFoundException, OrderNotFoundException, PromotionNotAvailableException {
        Order order = orderRepository.findIncompleteOrder(new OrderId(request.getOrderId()));
        Promotion promotion = promotionAdapter.getPromotion(new PromotionId(request.getPromotionId()));
        order.assignPromotion(promotion);

        orderRepository.save(order);
    }
}
