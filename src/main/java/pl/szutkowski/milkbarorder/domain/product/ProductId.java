package pl.szutkowski.milkbarorder.domain.product;

import pl.szutkowski.milkbarorder.domain.ValueObject.AggregateRootId;

public class ProductId extends AggregateRootId {
    public ProductId(String id) {
        super(id);
    }
}
