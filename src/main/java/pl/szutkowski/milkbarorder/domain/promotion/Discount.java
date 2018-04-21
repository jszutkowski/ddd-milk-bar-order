package pl.szutkowski.milkbarorder.domain.promotion;

import pl.szutkowski.milkbarorder.domain.Assert;
import pl.szutkowski.milkbarorder.domain.ValueObject.Price;

public class Discount {

    private static final int MIN_DISCOUNT = 0;
    private static final int MAX_DISCOUNT = 100;

    private int discount;

    public Discount(int discount) {
        Assert.assertBetween(discount, MIN_DISCOUNT, MAX_DISCOUNT, "Discount must be between 0 and 100");
        this.discount = discount;
    }

    public int discount() {
        return discount;
    }

    public Price fromPrice(Price price) {

        float priceValue = price.price();
        float discountValue = (float)(priceValue * discount / 100.0);
        float discountPrice = priceValue - discountValue;
        float rounded = (float) (Math.round(discountPrice * 100.0) / 100.0);

        return new Price(rounded);
    }
}
