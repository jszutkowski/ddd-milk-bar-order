package pl.szutkowski.milkbarorder.application.request;

public class RemoveProductRequest {
    private String orderId;
    private String productId;

    public RemoveProductRequest(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }
}
