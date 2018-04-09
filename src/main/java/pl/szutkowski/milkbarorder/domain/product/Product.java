package pl.szutkowski.milkbarorder.domain.product;

import pl.szutkowski.milkbarorder.domain.ValueObject.Price;

public class Product {
    private ProductId id;
    private String name;
    private Price price;

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Price price() {
        return price;
    }
}
