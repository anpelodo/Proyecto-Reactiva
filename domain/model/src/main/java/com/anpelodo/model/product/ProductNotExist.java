package com.anpelodo.model.product;

import com.anpelodo.model.shared.DomainError;

import java.math.BigInteger;

public class ProductNotExist extends DomainError {
    public ProductNotExist(BigInteger id) {
        super("product_not_exist", String.format("Product with id <%s> doesn't exist", id.toString()));
    }
}
