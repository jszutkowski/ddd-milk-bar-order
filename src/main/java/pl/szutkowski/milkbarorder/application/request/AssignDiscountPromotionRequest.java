package pl.szutkowski.milkbarorder.application.request;

import lombok.Data;

@Data
public class AssignDiscountPromotionRequest {
    private String promotionId;
    private String orderId;
}
