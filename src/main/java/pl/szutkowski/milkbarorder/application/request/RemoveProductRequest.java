package pl.szutkowski.milkbarorder.application.request;

import lombok.Data;

@Data
public class RemoveProductRequest {
    private String orderId;
    private String productId;
}
