package com.anpelodo.model.cart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartDetails {
    static final double TAX_RATE = 0.1;

    private List<CartItem> list;
    private int productCount;
    private double taxes;
    private double shipping;
    private double subtotal;
    private double total;

    public CartDetails(List<CartItem> list, double shipping) {
        this.list = list;
        this.shipping = shipping;
        calculateTotal();
    }

    private void calculateTotal() {
        subtotal = list.stream().mapToDouble(CartItem::getTotal).sum();
        taxes = subtotal * TAX_RATE;
        total = subtotal + taxes + shipping;
        productCount = list.stream().mapToInt(CartItem::getQuantity).sum();
    }
}
