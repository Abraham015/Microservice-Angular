package dev.abraham.product.service;

import dev.abraham.product.mapper.ProductMapper;
import dev.abraham.product.model.Product;
import dev.abraham.product.repository.ProductRepository;
import dev.abraham.product.request.ProductRequest;
import dev.abraham.product.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public String createProduct(ProductRequest product) {
        return productRepository.save(productMapper.toProduct(product)).getId();
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }
}
