package pl.szutkowski.milkbarorder.domain.ValueObject;

public class Quantity {
    private int quantity;

    public Quantity(int quantity) {
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
