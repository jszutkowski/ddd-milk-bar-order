package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.AggregateRootId;

public class OrderId extends AggregateRootId {
    public OrderId(String id) {
        super(id);
    }
}
