package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.product.ProductAdapter;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

public class OrderCheckerService {

    private ProductAdapter productAdapter;
    private PromotionAdapter promotionAdapter;

    public OrderCheckerService(ProductAdapter productAdapter, PromotionAdapter promotionAdapter) {
        this.productAdapter = productAdapter;
        this.promotionAdapter = promotionAdapter;
    }

    public boolean checkOrder(Order order) {
        boolean areProductsChanges = order.refreshProducts(productAdapter.getProducts());
        boolean isPromotionChanged = order.refreshPromotion(promotionAdapter.getPromotions());

        return areProductsChanges || isPromotionChanged;
    }
}
