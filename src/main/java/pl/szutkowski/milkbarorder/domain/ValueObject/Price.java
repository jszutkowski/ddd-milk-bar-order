package pl.szutkowski.milkbarorder.domain.ValueObject;

public class Price {
    private float price;

    public Price(float price) {
        this.price = price;
    }

    public static Price free() {
        return new Price(0);
    }

    public float price()
    {
        return price;
    }

    public boolean isEqual(Price price) {
        return this.price == price.price();
    }
}
