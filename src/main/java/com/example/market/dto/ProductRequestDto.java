package com.example.market.dto;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

}
