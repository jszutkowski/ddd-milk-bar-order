package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.Price;
import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.product.ProductId;

public class OrderItem {
    private OrderItemId id;
    private String name;
    private ProductId productId;
    private Price price;
    private Quantity quantity;
    private Order order;

    public OrderItem(OrderItemId id, String name, ProductId productId, Price price, Quantity quantity, Order order) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
    }

    public OrderItemId id() {
        return id;
    }

    public ProductId productId() {
        return productId;
    }

    public Quantity quantity() {
        return quantity;
    }

    public boolean isEmpty() {
        return quantity.quantity() == 0;
    }

    public void addQuantity(Quantity quantity) {
        this.quantity = new Quantity(this.quantity.quantity() + quantity.quantity());
    }

    public void decrementQuantity() {
        this.quantity = new Quantity(this.quantity.quantity() - 1);
    }
}
