package com.anpelodo.model.product.gateways;

import com.anpelodo.model.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface ProductRepository {
    Mono<Product> save(Product product);
    Mono<Product> update(Product product);
    Flux<Product> findAll();
    Mono<Product> findById(BigInteger id);
    Flux<Product> findByName(String name);
    Mono<Void> deleteById(BigInteger id);
    Mono<Boolean> existsById(BigInteger id);
}
