package pl.szutkowski.milkbarorder.application.request;

public class GetPromotionProductsRequest {
    private String orderId;
    private String promotionId;

    public GetPromotionProductsRequest(String orderId, String promotionId) {
        this.orderId = orderId;
        this.promotionId = promotionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPromotionId() {
        return promotionId;
    }
}
