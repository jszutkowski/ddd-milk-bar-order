package pl.szutkowski.milkbarorder.application.response;

import pl.szutkowski.milkbarorder.domain.order.Order;
import pl.szutkowski.milkbarorder.domain.promotion.Promotion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GetPromotionListResponse implements Serializable{

    private List<PromotionDTO> promotions;

    public GetPromotionListResponse(Order order, List<Promotion> allPromotions) {

        promotions = new ArrayList<>(allPromotions.size());

        for(Promotion promotion : allPromotions) {
            PromotionDTO dto = new PromotionDTO(
                    promotion.id().id(),
                    promotion.name(),
                    promotion.description(),
                    promotion.isAvailable(order)
            );
            promotions.add(dto);
        }
    }

    private class PromotionDTO implements Serializable{
        private String id;
        private String name;
        private String description;
        private boolean isAvailable;

        PromotionDTO(String id, String name, String description, boolean isAvailable) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.isAvailable = isAvailable;
        }
    }
}
