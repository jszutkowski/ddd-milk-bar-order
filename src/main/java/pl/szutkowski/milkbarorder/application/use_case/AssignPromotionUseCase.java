package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.AssignPromotionRequest;
import pl.szutkowski.milkbarorder.domain.order.*;
import pl.szutkowski.milkbarorder.domain.promotion.*;

public class AssignPromotionUseCase {

    private PromotionAdapter promotionAdapter;
    private PromotionAvailabilityChecker availabilityChecker;
    private OrderRepository orderRepository;

    public AssignPromotionUseCase(PromotionAdapter promotionAdapter,
                                  PromotionAvailabilityChecker availabilityChecker,
                                  OrderRepository orderRepository) {

        this.promotionAdapter = promotionAdapter;
        this.availabilityChecker = availabilityChecker;
        this.orderRepository = orderRepository;
    }

    public void execute(AssignPromotionRequest request) throws PromotionNotFoundException, OrderNotFoundException, PromotionNotAvailableException {
        Promotion promotion = promotionAdapter.getPromotion(new PromotionId(request.getPromotionId()));
        Order order = orderRepository.findIncompleteOrder(new OrderId(request.getOrderId()));

        order.assignPromotion(promotion);

        orderRepository.save(order);
    }
}
