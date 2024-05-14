package com.anpelodo.r2dbc.cart;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("cart_items")
public class CartItemData {
    @Id
    private BigInteger id;

    @Column("user_id")
    private BigInteger userId;

    @Column("product_id")
    private BigInteger productId;

    @Column("product_price")
    private double productPrice;

    private Integer quantity;

    public CartItemData(BigInteger id, BigInteger userId, BigInteger productId, Integer quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.productPrice = 0.0;
        this.quantity = quantity;
    }
}
