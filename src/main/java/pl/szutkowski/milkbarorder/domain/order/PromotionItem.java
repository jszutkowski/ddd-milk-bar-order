package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.Price;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionId;

public class PromotionItem {

    private PromotionItemId id;
    private PromotionId promotionId;
    private String promotionName;
    private String promotionDescription;
    private Price price;

    public PromotionItem(PromotionItemId id, PromotionId promotionId, Price price, String promotionName, String promotionDescription) {
        this.id = id;
        this.promotionId = promotionId;
        this.price = price;
        this.promotionName = promotionName;
        this.promotionDescription = promotionDescription;
    }

    public PromotionItemId id() {
        return id;
    }

    public PromotionId promotionId() {
        return promotionId;
    }

    public Price price() {
        return price;
    }

    public String promotionName() {
        return promotionName;
    }

    public String promotionDescription() {
        return promotionDescription;
    }
}
