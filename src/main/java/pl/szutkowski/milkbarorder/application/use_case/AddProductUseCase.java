package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.AddProductRequest;
import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.order.*;
import pl.szutkowski.milkbarorder.domain.product.Product;
import pl.szutkowski.milkbarorder.domain.product.ProductAdapter;
import pl.szutkowski.milkbarorder.domain.product.ProductId;
import pl.szutkowski.milkbarorder.domain.product.ProductNotFoundException;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

public class AddProductUseCase {

    private final OrderRepository orderRepository;
    private final ProductAdapter productAdapter;
    private final AddProductService addProductService;

    public AddProductUseCase(OrderRepository orderRepository,
                             ProductAdapter productAdapter,
                             AddProductService addProductService) {

        this.orderRepository = orderRepository;
        this.productAdapter = productAdapter;
        this.addProductService = addProductService;
    }

    public void execute(AddProductRequest request) throws OrderNotFoundException, ProductNotFoundException {

        OrderId orderId = new OrderId(request.getOrderId());
        Order order = orderRepository.findIncompleteOrder(orderId);

        Product product = productAdapter.getProduct(new ProductId(request.getProductId()));
        Quantity quantity = new Quantity(request.getQuantity());

        addProductService.addProduct(order, product, quantity);
        orderRepository.save(order);
    }
}
