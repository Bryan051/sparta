package com.example.market.controller;

import com.example.market.dto.ProductRequestDto;
import com.example.market.dto.ProductResponseDto;
import com.example.market.entity.Product;
import com.example.market.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    @GetMapping("/post")
    public List<ProductResponseDto> getProduct() {
        return productService.getProduct();
    }

    @PutMapping("/post/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) {
        return productService.updateProduct(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }


}
