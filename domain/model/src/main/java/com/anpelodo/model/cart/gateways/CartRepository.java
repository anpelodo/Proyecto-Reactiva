package com.anpelodo.model.cart.gateways;

import com.anpelodo.model.cart.CartItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface CartRepository {
    Mono<CartItem> save(CartItem cartItem);

    Flux<CartItem> findAll(BigInteger userId);

    Mono<CartItem> findById(BigInteger id);

    Mono<Void> removeProductFromCart(BigInteger id);

    Mono<Void> removeAll(BigInteger userId);

    Mono<Integer> count(BigInteger userId);
}
