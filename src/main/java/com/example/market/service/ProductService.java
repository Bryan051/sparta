package com.example.market.service;

import com.example.market.Repository.ProductRepository;
import com.example.market.dto.ProductRequestDto;
import com.example.market.dto.ProductResponseDto;
import com.example.market.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        // Dto -> Entity
        Product product = new Product(requestDto);

        //DB 저장
        Product saveProduct = productRepository.save(product);

        ProductResponseDto productResponseDto = new ProductResponseDto(saveProduct);

        return productResponseDto;
    }

    public List<ProductResponseDto> getProduct() {
        // DB 조회
        return productRepository.findAll().stream().map(ProductResponseDto::new).toList();
    }

    @Transactional
    public Product updateProduct(Long id, ProductRequestDto requestDto) {
        // 해당 product 가 DB에 존재하는지 확인
        Product product = findProduct(id);

        //  내용 수정
        product.update(requestDto);

        return productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시물은 존재하지않습니다.")
        );
    }

    public Long deleteProduct(Long id) {
        // 해당 product 가 DB에 존재하는지 확인
        Product product = findProduct(id);
        // 삭제
        productRepository.delete(product);

        return id;
    }

    private Product findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시물은 존재하지않습니다.")
        );
    }



}
