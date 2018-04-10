package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.GetOrderRequest;
import pl.szutkowski.milkbarorder.application.response.GetOrderResponse;
import pl.szutkowski.milkbarorder.domain.order.*;

public class GetOrderUseCase {

    private OrderRepository orderRepository;
    private OrderCheckerService orderCheckerService;

    public GetOrderUseCase(OrderRepository orderRepository, OrderCheckerService orderCheckerService) {
        this.orderRepository = orderRepository;
        this.orderCheckerService = orderCheckerService;
    }


    public GetOrderResponse execute(GetOrderRequest request) throws OrderNotFoundException {
        Order order = orderRepository.findIncompleteOrder(new OrderId(request.getOrderId()));

        boolean isOrderChanged = orderCheckerService.checkOrder(order);
        if (isOrderChanged) {
            orderRepository.save(order);
        }

        return new GetOrderResponse(order);
    }
}
