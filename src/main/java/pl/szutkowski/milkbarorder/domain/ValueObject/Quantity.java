package pl.szutkowski.milkbarorder.domain.ValueObject;

import pl.szutkowski.milkbarorder.domain.Assert;

public class Quantity {

    private static int MIN_QUANTITY = 1;

    private int quantity;

    public Quantity(int quantity) {

        Assert.assertGreaterThanOrEqual(quantity, MIN_QUANTITY, "Quantity must be greater or equal than 0");

        this.quantity = quantity;
    }

    public int quantity()
    {
        return quantity;
    }

    public boolean isGreaterOrEqual(Quantity quantity) {
        return this.quantity >= quantity.quantity();
    }
}
