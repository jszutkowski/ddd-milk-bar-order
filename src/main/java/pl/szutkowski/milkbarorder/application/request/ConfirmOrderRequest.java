package pl.szutkowski.milkbarorder.application.request;

import lombok.Data;

@Data
public class ConfirmOrderRequest {
    private String orderId;
}
