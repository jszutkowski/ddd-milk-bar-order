package pl.szutkowski.milkbarorder.domain.product;

import pl.szutkowski.milkbarorder.domain.category.CategoryId;
import pl.szutkowski.milkbarorder.domain.ValueObject.Price;

public class Product {
    private ProductId id;
    private String name;
    private String description;
    private Price price;
    private CategoryId categoryId;

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Price price() {
        return price;
    }

    public CategoryId categoryId() {
        return categoryId;
    }
}
