package com.anpelodo.r2dbc.product;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

public interface ProductPostgresRepository extends ReactiveCrudRepository<ProductData, BigInteger>, ReactiveQueryByExampleExecutor<ProductData> {
    Flux<ProductData> findAllByNameLikeIgnoreCase(String name);
}
