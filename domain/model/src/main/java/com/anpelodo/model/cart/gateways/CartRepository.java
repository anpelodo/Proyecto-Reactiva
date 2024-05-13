package com.anpelodo.model.cart.gateways;

import com.anpelodo.model.cart.CartItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface CartRepository {
    Mono<CartItem> save(CartItem cartItem);
    Mono<CartItem> update(CartItem cartItem);
    Flux<CartItem> findAll(BigInteger userId);
    Mono<Void> removeProductFromCart(CartItem cartItem);
    Mono<Void> removeAll(BigInteger userId);
    Mono<Boolean> exist(CartItem cartItem);
    Mono<Integer> count(BigInteger userId);
}
