package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.RemoveProductRequest;
import pl.szutkowski.milkbarorder.domain.order.*;
import pl.szutkowski.milkbarorder.domain.product.ProductId;

public class RemoveProductUseCase {

    private final OrderRepository orderRepository;
    private final BasketOrderRefresher orderRefresher;

    public RemoveProductUseCase(OrderRepository orderRepository, BasketOrderRefresher orderRefresher) {

        this.orderRepository = orderRepository;
        this.orderRefresher = orderRefresher;
    }

    public void execute(RemoveProductRequest request) throws OrderNotFoundException {

        OrderId orderId = new OrderId(request.getOrderId());
        Order order = orderRepository.findIncompleteOrder(orderId);
        order.decrementProductsQuantity(new ProductId(request.getProductId()));
        orderRefresher.refreshOrder(order);
        orderRepository.save(order);
    }
}
