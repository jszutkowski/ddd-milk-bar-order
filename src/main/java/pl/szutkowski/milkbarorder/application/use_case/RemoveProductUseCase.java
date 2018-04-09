package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.AddProductRequest;
import pl.szutkowski.milkbarorder.domain.order.Order;
import pl.szutkowski.milkbarorder.domain.order.OrderId;
import pl.szutkowski.milkbarorder.domain.order.OrderNotFoundException;
import pl.szutkowski.milkbarorder.domain.order.OrderRepository;
import pl.szutkowski.milkbarorder.domain.product.ProductId;

public class RemoveProductUseCase {

    private final OrderRepository orderRepository;

    public RemoveProductUseCase(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public void execute(AddProductRequest request) throws OrderNotFoundException {

        OrderId orderId = new OrderId(request.getOrderId());
        Order order = orderRepository.findIncompleteOrder(orderId);
        order.removeOneProduct(new ProductId(request.getProductId()));
        orderRepository.save(order);
    }
}
