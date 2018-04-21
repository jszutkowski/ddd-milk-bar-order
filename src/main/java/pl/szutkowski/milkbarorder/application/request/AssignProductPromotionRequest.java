package pl.szutkowski.milkbarorder.application.request;

import lombok.Data;

@Data
public class AssignProductPromotionRequest {
    private String promotionId;
    private String productId;
    private String orderId;
}
