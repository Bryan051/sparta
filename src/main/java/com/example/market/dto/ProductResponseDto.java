package com.example.market.dto;

import com.example.market.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {

    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.content = product.getContent();
        this.price = product.getPrice();
        this.username = product.getUsername();
    }

}
