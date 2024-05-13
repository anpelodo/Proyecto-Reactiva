package com.anpelodo.model.product;
import lombok.*;

import java.math.BigInteger;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Product {
    private BigInteger id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private int stock;

    Product(BigInteger id, String name, String description, double price, String imageUrl) {
        this(id, name, description, price, imageUrl, 0);
    }
}

