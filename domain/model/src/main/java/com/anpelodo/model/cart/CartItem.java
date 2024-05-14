package com.anpelodo.model.cart;

import lombok.*;

import java.math.BigInteger;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CartItem {
    private BigInteger id;
    private BigInteger userId;
    private BigInteger productId;
    private double productPrice;
    private Integer quantity;

    public double getTotal() {
        return productPrice * quantity;
    }
}
