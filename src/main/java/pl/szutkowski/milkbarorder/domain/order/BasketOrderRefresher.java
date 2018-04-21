package pl.szutkowski.milkbarorder.domain.order;

public class BasketOrderRefresher {

    private BasketProductRefresher productRefresher;
    private BasketPromotionRefresher promotionRefresher;

    public BasketOrderRefresher(BasketProductRefresher productRefresher, BasketPromotionRefresher promotionRefresher) {
        this.productRefresher = productRefresher;
        this.promotionRefresher = promotionRefresher;
    }

    public void refreshOrder(Order order) {
        productRefresher.refreshProducts(order);
        promotionRefresher.refreshPromotions(order);
    }
}
