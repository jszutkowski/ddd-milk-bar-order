package pl.szutkowski.milkbarorder.domain.promotion;

import java.util.List;

public interface PromotionAdapter {

    Promotion getPromotion(PromotionId promotionId) throws PromotionNotFoundException;
    List<Promotion> getPromotions();

}
