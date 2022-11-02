package com.demo.apiTest.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String seller_id;
    private int price;
    private String description;
}
