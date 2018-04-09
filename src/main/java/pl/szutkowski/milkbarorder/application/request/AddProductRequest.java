package pl.szutkowski.milkbarorder.application.request;

import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;

public class AddProductRequest {
    private String orderId;
    private String productId;
    private int quantity;

    public AddProductRequest(String orderId, String productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
