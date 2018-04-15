package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.Price;
import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.category.CategoryId;
import pl.szutkowski.milkbarorder.domain.customer.Customer;
import pl.szutkowski.milkbarorder.domain.product.Product;
import pl.szutkowski.milkbarorder.domain.product.ProductId;
import pl.szutkowski.milkbarorder.domain.promotion.Promotion;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionId;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionNotAvailableException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private OrderId id;
    private Price totalPrice;
    private Customer customer;
    private List<OrderItem> items;
    private List<PromotionId> availablePromotions;
    private PromotionItem promotionItem;


    public Order(OrderId id,
                 Price totalPrice,
                 Customer customer,
                 List<OrderItem> items,
                 List<PromotionId> availablePromotions,
                 PromotionItem promotionItem) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.items = items;
        this.availablePromotions = availablePromotions;
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

    public boolean hasPromotion() {
        return promotionItem != null;
    }

    public void removeExpiredPromotion() {
        if (!hasPromotion()) {
            return;
        }

        PromotionId currentPromotionId = promotionItem.promotionId();
        for (PromotionId availablePromotionId : availablePromotions) {
            if (availablePromotionId.equals(currentPromotionId)) {
                return;
            }
        }

        promotionItem = null;
    }

    public void assignCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean hasProductQuantity(ProductId productId, Quantity quantity) {
        for (OrderItem item : items) {
            if (item.productId().equals(productId)) {
                return item.quantity().isGreaterOrEqual(quantity);
            }
        }

        return false;
    }

    public boolean hasCategoryProductQuantity(CategoryId categoryId, Quantity quantity) {
        int productsQuantity = 0;
        for (OrderItem item : items) {
            if (item.categoryId().equals(categoryId)) {
                productsQuantity += item.quantity().quantity();
            }
        }

        return new Quantity(productsQuantity).isGreaterOrEqual(quantity);

    }

    public void addProduct(OrderItemId id, Product product, Quantity quantity) {
        for (OrderItem item : items) {
            if (item.productId().equals(product.id())) {
                item.addQuantity(quantity);
                return;
            }
        }

        OrderItem newItem = new OrderItem(id, product.name(), product.id(), product.categoryId(), product.price(), quantity, this);
        this.items.add(newItem);
    }

    public void decrementProductsQuantity(ProductId productId) {
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

    public void setAvailablePromotions(List<Promotion> allPromotions) {
        availablePromotions.clear();
        for (Promotion promotion : allPromotions) {
            if (promotion.isAvailable(this)) {
                availablePromotions.add(promotion.id());
            }
        }
    }

    public void assignPromotion(Promotion promotion) throws PromotionNotAvailableException {
        if (!promotion.isAvailable(this)) {
            throw new PromotionNotAvailableException();
        }

        /**
         * @TODO:
         * add promotion
         */
    }

    public boolean refreshProducts(List<Product> products) {

        boolean isListChanged = false;
        Map<ProductId, Price> productMap = getProductsMap(products);

        for (OrderItem item : items) {
            Price currentPrice = productMap.get(item.productId());

            if (currentPrice == null) {
                items.remove(item);
                isListChanged = true;
            } else if (!item.isItemPriceEqual(currentPrice)) {
                item.changePrice(currentPrice);
                isListChanged = true;
            }
        }

        return isListChanged;
    }

    /**
     * @TODO: remove this method
     */
    public boolean refreshPromotion(List<Promotion> promotions) {
        if (promotionItem == null) {
            return false;
        }

        Promotion promotion = getPromotionFromList(promotionItem.promotionId(), promotions);

        if (promotion == null || !promotion.isAvailable(this)) {
            promotionItem = null;
            return true;
        }

        return false;
    }

    private Map<ProductId, Price> getProductsMap(List<Product> products) {
        Map<ProductId, Price> productMap = new HashMap<>(products.size());

        for (Product product : products) {
            productMap.put(product.id(), product.price());
        }

        return productMap;
    }

    /**
     * @TODO: remove this method
     */
    private Promotion getPromotionFromList(PromotionId promotionId, List<Promotion> promotions) {
        for (Promotion promotion : promotions) {
            if (promotion.id().equals(promotionId)) {
                return promotion;
            }
        }

        return null;
    }


}
