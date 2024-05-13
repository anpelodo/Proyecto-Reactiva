package com.anpelodo.r2dbc.product;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("products")
public class ProductData {
    @Id
    private BigInteger id;

    private String name;

    private String description;

    private double price;

    @Column("image_url")
    private String imageUrl;

    private int stock;
}
