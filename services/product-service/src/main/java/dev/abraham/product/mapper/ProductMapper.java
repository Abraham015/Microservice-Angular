package dev.abraham.product.mapper;

import dev.abraham.product.model.Product;
import dev.abraham.product.request.ProductRequest;
import dev.abraham.product.response.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest product) {
        return Product.builder()
                .name(product.name())
                .description(product.description())
                .price(product.price())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
