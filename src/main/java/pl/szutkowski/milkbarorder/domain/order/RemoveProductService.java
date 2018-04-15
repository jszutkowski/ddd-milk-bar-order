package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.product.ProductId;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

public class RemoveProductService extends BaseProductService {

    public RemoveProductService(PromotionAdapter promotionAdapter) {
        super(promotionAdapter);
    }

    public void removeProduct(Order order, ProductId productId) {
        order.decrementProductsQuantity(productId);
        setAvailablePromotions(order);
        order.removeExpiredPromotion();
    }
}
