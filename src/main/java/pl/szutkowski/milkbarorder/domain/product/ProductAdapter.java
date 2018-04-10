package pl.szutkowski.milkbarorder.domain.product;

import java.util.List;

public interface ProductAdapter {

    Product getProduct(ProductId productId) throws ProductNotFoundException;
    List<Product> getProducts();
}
