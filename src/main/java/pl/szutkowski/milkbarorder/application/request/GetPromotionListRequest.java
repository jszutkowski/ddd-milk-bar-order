package pl.szutkowski.milkbarorder.application.request;

public class GetPromotionListRequest {

    private String orderId;

    public GetPromotionListRequest(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
