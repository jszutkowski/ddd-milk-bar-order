package pl.szutkowski.milkbarorder.application.request;

public class GetOrderRequest {

    private String orderId;

    public GetOrderRequest(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
