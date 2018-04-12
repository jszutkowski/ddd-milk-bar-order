package pl.szutkowski.milkbarorder.application.response;

import pl.szutkowski.milkbarorder.domain.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GetPromotionProductsResponse {
    private List<ProductDTO> products;

    public GetPromotionProductsResponse(List<Product> products) {

        this.products = new ArrayList<>(products.size());

        for (Product product : products) {
            this.products.add(new ProductDTO(product.id().id(), product.name(), product.price().price()));
        }
    }

    private class ProductDTO implements Serializable {
        private String id;
        private String name;
        private float price;

        public ProductDTO(String id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }
    }
}
