package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.promotion.Promotion;

public class PromotionAvailabilityChecker {
    public boolean isPromotionAvailable(Promotion promotion, Order order) {
        return true;
    }
}
