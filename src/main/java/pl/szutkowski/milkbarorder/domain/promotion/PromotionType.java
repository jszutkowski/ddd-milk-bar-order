package pl.szutkowski.milkbarorder.domain.promotion;

public class PromotionType {
    public static final int TYPE_PRODUCT = 1;
    public static final int TYPE_DISCOUNT = 2;

    private int type;

    public PromotionType(int type) {
        this.type = type;
    }

    public boolean isProductPromotion() {
        return type == TYPE_PRODUCT;
    }

    public boolean isDiscountPromotion() {
        return type == TYPE_DISCOUNT;
    }
}
