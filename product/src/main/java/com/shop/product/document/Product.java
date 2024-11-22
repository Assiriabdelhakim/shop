package com.shop.product.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter @Getter
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private String color;


}

