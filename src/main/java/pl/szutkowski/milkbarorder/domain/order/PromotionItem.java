package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.Price;
import pl.szutkowski.milkbarorder.domain.product.ProductId;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionId;

public class PromotionItem {

    private PromotionItemId id;
    private PromotionId promotionId;
    private ProductId productId;
    private String itemName;
    private String itemDescription;
    private Price price;

    public PromotionItem(PromotionItemId id, PromotionId promotionId, ProductId productId, Price price, String promotionName, String promotionDescription) {
        this.id = id;
        this.promotionId = promotionId;
        this.productId = productId;
        this.price = price;
        this.itemName = promotionName;
        this.itemDescription = promotionDescription;
    }

    public PromotionItemId id() {
        return id;
    }

    public PromotionId promotionId() {
        return promotionId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Price price() {
        return price;
    }

    public String itemName() {
        return itemName;
    }

    public String itemDescription() {
        return itemDescription;
    }
}
