package com.example.market.entity;

import com.example.market.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Item")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "USERNAME")
    private String username;

    public Product(ProductRequestDto productRequestDto) {
        this.id = productRequestDto.getId();
        this.username = productRequestDto.getUsername();
        this.content = productRequestDto.getContent();
        this.title = productRequestDto.getTitle();
        this.price = productRequestDto.getPrice();
    }

    public void update(ProductRequestDto productRequestDto) {
        this.username = productRequestDto.getUsername();
        this.content = productRequestDto.getContent();
        this.title = productRequestDto.getTitle();
        this.price = productRequestDto.getPrice();
    }


}
