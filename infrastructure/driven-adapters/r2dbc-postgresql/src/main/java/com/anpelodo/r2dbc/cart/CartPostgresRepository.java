package com.anpelodo.r2dbc.cart;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface CartPostgresRepository
        extends Repository<CartItemData, BigInteger> {

    Mono<CartItemData> save(CartItemData cartItem);

    @Query("SELECT c.id, c.user_id, c.product_id, p.price product_price, c.quantity " +
            "FROM cart_items c " +
            "JOIN products p ON c.product_id = p.id " +
            "WHERE c.user_id = :userId")
    Flux<CartItemData> findAllByUserId(@Param("userId") BigInteger userId);

    @Query("SELECT c.id, c.user_id, c.product_id, p.price product_price, c.quantity " +
            "FROM cart_items c " +
            "JOIN products p ON c.product_id = p.id " +
            "WHERE c.id = :id " +
            "LIMIT 1")
    Mono<CartItemData> findById(BigInteger id);

    Mono<Boolean> deleteById(BigInteger id);

    Mono<Integer> deleteAllByUserId(BigInteger userId);

    Mono<Integer> countByUserId(BigInteger userId);
}
