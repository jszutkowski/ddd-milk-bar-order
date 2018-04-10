package pl.szutkowski.milkbarorder.application.request;

public class AssignPromotionRequest {
    private String promotionId;
    private String orderId;

    public AssignPromotionRequest(String promotionId, String orderId) {
        this.promotionId = promotionId;
        this.orderId = orderId;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public String getOrderId() {
        return orderId;
    }
}
