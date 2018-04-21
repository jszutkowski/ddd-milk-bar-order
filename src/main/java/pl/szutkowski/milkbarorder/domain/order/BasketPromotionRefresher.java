package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.promotion.Promotion;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

import java.util.List;

public class BasketPromotionRefresher {

    private PromotionAdapter promotionAdapter;

    BasketPromotionRefresher(PromotionAdapter promotionAdapter) {
        this.promotionAdapter = promotionAdapter;
    }

    public void refreshPromotions(Order order) {
        setAvailablePromotions(order);
        /**
         * Recalculate promotion if exist
         */
    }

    private void setAvailablePromotions(Order order) {
        List<Promotion> promotions = promotionAdapter.getPromotions();
        order.setAvailablePromotions(promotions);
    }
}
