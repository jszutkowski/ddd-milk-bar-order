package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.AddProductRequest;
import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.order.*;
import pl.szutkowski.milkbarorder.domain.product.Product;
import pl.szutkowski.milkbarorder.domain.product.ProductAdapter;
import pl.szutkowski.milkbarorder.domain.product.ProductId;
import pl.szutkowski.milkbarorder.domain.product.ProductNotFoundException;

public class AddProductUseCase {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductAdapter productAdapter;
    private final BasketOrderRefresher orderRefresher;

    public AddProductUseCase(OrderRepository orderRepository,
                             OrderItemRepository orderItemRepository,
                             ProductAdapter productAdapter,
                             BasketOrderRefresher orderRefresher) {

        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productAdapter = productAdapter;
        this.orderRefresher = orderRefresher;
    }

    public void execute(AddProductRequest request) throws OrderNotFoundException, ProductNotFoundException {

        Order order = orderRepository.findIncompleteOrder(new OrderId(request.getOrderId()));

        Product product = productAdapter.getProduct(new ProductId(request.getProductId()));
        Quantity quantity = new Quantity(request.getQuantity());

        order.addProduct(orderItemRepository.nextId(), product, quantity);
        orderRefresher.refreshOrder(order);
        orderRepository.save(order);
    }
}
