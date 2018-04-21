package pl.szutkowski.milkbarorder.application.request;

import lombok.Data;

@Data
public class AddProductRequest {
    private String orderId;
    private String productId;
    private int quantity;
}
