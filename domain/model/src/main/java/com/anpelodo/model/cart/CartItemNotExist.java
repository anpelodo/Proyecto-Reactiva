package com.anpelodo.model.cart;

import com.anpelodo.model.shared.DomainError;

public class CartItemNotExist extends DomainError {
    public CartItemNotExist(CartItem cartItem) {
        super(
"cart_not_exist",
                String.format(
                        "CartItem with userId <%s> and productId <%s> doesn't exist",
                        cartItem.getUserId(),
                        cartItem.getProductId()
                )
        );
    }
}
