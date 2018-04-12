package pl.szutkowski.milkbarorder.domain.promotion;

import pl.szutkowski.milkbarorder.domain.category.CategoryId;
import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.order.Order;
import pl.szutkowski.milkbarorder.domain.product.ProductId;

public class Promotion {
    private PromotionId id;
    private String name;
    private String description;
    private PromotionType type;
    private Days days;
    private Hours hours;
    private ProductId requiredProductId;
    private CategoryId requiredCategoryId;
    private Quantity requiredQuantity;
    private CategoryId promotionCategoryId;
    private ProductId promotionProductId;
    private Discount discount;

    public Promotion(PromotionId id,
                     String name,
                     String description,
                     PromotionType type,
                     Days days,
                     Hours hours,
                     ProductId requiredProductId,
                     CategoryId requiredCategoryId,
                     Quantity requiredQuantity,
                     CategoryId promotionCategoryId,
                     ProductId promotionProductId,
                     Discount discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.days = days;
        this.hours = hours;
        this.requiredProductId = requiredProductId;
        this.requiredCategoryId = requiredCategoryId;
        this.requiredQuantity = requiredQuantity;
        this.promotionCategoryId = promotionCategoryId;
        this.promotionProductId = promotionProductId;
        this.discount = discount;
    }

    public PromotionId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public PromotionType type() {
        return type;
    }

    public Days days() {
        return days;
    }

    public Hours hours() {
        return hours;
    }

    public ProductId requiredProductId() {
        return requiredProductId;
    }

    public CategoryId requiredCategoryId() {
        return requiredCategoryId;
    }

    public Quantity requiredQuantity() {
        return requiredQuantity;
    }

    public CategoryId promotionCategoryId() {
        return promotionCategoryId;
    }

    public ProductId promotionProductId() {
        return promotionProductId;
    }

    public Discount discount() {
        return discount;
    }

    public boolean isAvailable(Order order) {
        if (!checkTimeAvailability()) {
            return false;
        }

        if (type.isDiscountPromotion()) {
            return isDiscountPromotionAvailable(order);
        } else if (type.isProductPromotion()) {
            return isProductPromotionAvailable(order);
        } else {
            /**
             * @TODO
             * Or maybe throw exception because the type is invalid?
             */
            return false;
        }
    }

    private boolean isProductPromotionAvailable(Order order) {

        if (requiredCategoryId != null) {
            return order.hasCategoryProductQuantity(requiredCategoryId, requiredQuantity);
        } else if (requiredProductId != null) {
            return order.hasProductQuantity(requiredProductId, requiredQuantity);
        } else {
            /**
             * @TODO
             * Maybe excepton?
             */
            return false;
        }
    }

    private boolean isDiscountPromotionAvailable(Order order) {

        return true;
    }

    private boolean checkTimeAvailability() {
        return days.hasCurrentDay() && hours.isBetween();
    }
}
