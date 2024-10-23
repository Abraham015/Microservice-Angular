package dev.abraham.product.controller;

import dev.abraham.product.model.Product;
import dev.abraham.product.request.ProductRequest;
import dev.abraham.product.response.ProductResponse;
import dev.abraham.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


}
