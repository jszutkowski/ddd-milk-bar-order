package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.ValueObject.Quantity;
import pl.szutkowski.milkbarorder.domain.product.Product;
import pl.szutkowski.milkbarorder.domain.promotion.PromotionAdapter;

public class AddProductService extends BaseProductService {

    private OrderItemRepository orderItemRepository;

    public AddProductService(PromotionAdapter promotionAdapter, OrderItemRepository orderItemRepository) {
        super(promotionAdapter);
        this.orderItemRepository = orderItemRepository;
    }

    public void addProduct(Order order, Product product, Quantity quantity) {
        order.addProduct(orderItemRepository.nextId(), product, quantity);
        setAvailablePromotions(order);
    }
}
