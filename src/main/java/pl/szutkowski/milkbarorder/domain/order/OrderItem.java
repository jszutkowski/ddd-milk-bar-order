package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.Price;
import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.category.CategoryId;
import pl.szutkowski.milkbarorder.domain.product.ProductId;

public class OrderItem {
    private OrderItemId id;
    private String name;
    private ProductId productId;
    private CategoryId categoryId;
    private Price price;
    private Quantity quantity;
    private Order order;

    public OrderItem(OrderItemId id, String name, ProductId productId, CategoryId categoryId, Price price, Quantity quantity, Order order) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.categoryId = categoryId;
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

    public CategoryId categoryId() {
        return categoryId;
    }

    public Quantity quantity() {
        return quantity;
    }

    public Price price() {
        return price;
    }

    public void changePrice(Price newPrice) {
        this.price = newPrice;
    }

    public boolean isItemPriceEqual(Price price) {
        return this.price.isEqual(price);
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
