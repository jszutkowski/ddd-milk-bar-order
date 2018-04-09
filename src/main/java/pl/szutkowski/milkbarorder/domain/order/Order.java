package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.Price;
import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.customer.Customer;
import pl.szutkowski.milkbarorder.domain.product.Product;
import pl.szutkowski.milkbarorder.domain.product.ProductId;
import pl.szutkowski.milkbarorder.domain.promotion.Promotion;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionId;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionNotAvailableException;

import java.util.List;

public class Order {
    private OrderId id;
    private Price totalPrice;
    private Customer customer;
    private List<OrderItem> items;
    private PromotionItem promotionItem;

    public Order(OrderId id, Price totalPrice, Customer customer, List<OrderItem> items, PromotionItem promotionItem) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.items = items;
        this.promotionItem = promotionItem;
    }

    public OrderId id() {
        return id;
    }

    public Price totalPrice() {
        return totalPrice;
    }

    public Customer customer() {
        return customer;
    }

    public List<OrderItem> items() {
        return items;
    }

    public PromotionItem promotion() {
        return promotionItem;
    }

    public void addProduct(OrderItemRepository repository, Product product, Quantity quantity) {
        for (OrderItem item : items) {
            if (item.productId().equals(product.id())) {
                item.addQuantity(quantity);
                return;
            }
        }

        OrderItem newItem = new OrderItem(repository.nextId(), product.name(), product.id(), product.price(), quantity, this);
        this.items.add(newItem);
    }

    public void removeOneProduct(ProductId productId) {
        for (OrderItem item : items) {
            if (item.productId().equals(productId)) {
                item.decrementQuantity();
                if (item.isEmpty()) {
                    items.remove(item);
                }
                break;
            }
        }
    }

    public void assignPromotion(PromotionAvailabilityChecker availabilityChecker, Promotion promotion) throws PromotionNotAvailableException {
        if (!availabilityChecker.isPromotionAvailable(promotion, this)) {
            throw new PromotionNotAvailableException();
        }

        /**
         * @TODO:
         * add promotion
         */
    }


}
