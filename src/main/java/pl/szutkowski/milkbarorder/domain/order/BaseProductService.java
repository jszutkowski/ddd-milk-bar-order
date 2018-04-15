package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.promotion.Promotion;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

import java.util.List;

abstract class BaseProductService {

    protected PromotionAdapter promotionAdapter;

    BaseProductService(PromotionAdapter promotionAdapter) {
        this.promotionAdapter = promotionAdapter;
    }

    protected void setAvailablePromotions(Order order) {
        List<Promotion> promotions = promotionAdapter.getPromotions();
        order.setAvailablePromotions(promotions);
    }
}
