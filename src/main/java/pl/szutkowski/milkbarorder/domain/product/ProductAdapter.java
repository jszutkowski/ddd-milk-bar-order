package pl.szutkowski.milkbarorder.domain.product;

public interface ProductAdapter {

    Product getProduct(ProductId productId) throws ProductNotFoundException;
}
