package pl.szutkowski.milkbarorder.domain.promotion;

import pl.szutkowski.milkbarorder.domain.ValueObject.AggregateRootId;

public class PromotionId extends AggregateRootId{
    public PromotionId(String id) {
        super(id);
    }
}
