package com.demo.apiTest.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "seller_id")
    private String seller_id;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Builder
    public Product(String name, String seller_id, int price, String description) {
        this.name = name;
        this.seller_id = seller_id;
        this.price = price;
        this.description = description;
    }
}
