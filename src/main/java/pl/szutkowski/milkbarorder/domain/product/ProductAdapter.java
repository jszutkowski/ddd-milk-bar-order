package pl.szutkowski.milkbarorder.domain.product;

import pl.szutkowski.milkbarorder.domain.promotion.PromotionId;

import java.util.List;

public interface ProductAdapter {

    Product getProduct(ProductId productId) throws ProductNotFoundException;
    List<Product> getProducts();
    List<Product> getPromotionProducts(PromotionId promotionId);
}
