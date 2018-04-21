package pl.szutkowski.milkbarorder.domain.customer;

import pl.szutkowski.milkbarorder.domain.ValueObject.AggregateRootId;

public class CustomerId extends AggregateRootId {
    public CustomerId(String id) {
        super(id);
    }
}
