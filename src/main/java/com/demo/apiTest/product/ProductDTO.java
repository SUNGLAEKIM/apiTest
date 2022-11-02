package com.demo.apiTest.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "ProductDTO", description = "Product Data")
public class ProductDTO {
    @Schema(description = "id", defaultValue = "Auto_Increment", allowableValues = "Long", example = "1")
    private Long id;

    @Schema(description = "name", defaultValue = "None", allowableValues = "String", example = "product1")
    private String name;

    @Schema(description = "seller_id", defaultValue = "None", allowableValues = "String", example = "seller1")
    private String seller_id;

    @Schema(description = "price", defaultValue = "0", allowableValues = "Integer", example = "1000")
    private int price;

    @Schema(description = "description", defaultValue = "None", allowableValues = "String", example = "description1")
    private String description;
}
