package com.anpelodo.r2dbc.cart;

import com.anpelodo.model.cart.CartItem;
import com.anpelodo.model.cart.gateways.CartRepository;
import com.anpelodo.r2dbc.helper.ReactiveAdapter;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Repository
public class CartPostgresRepositoryAdapter
        extends ReactiveAdapter<CartItem, CartItemData, BigInteger, CartPostgresRepository>
        implements CartRepository {
    public CartPostgresRepositoryAdapter(CartPostgresRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, CartItem.class));
    }

    @Override
    public Mono<CartItem> save(CartItem cartItem) {
        return repository.save(this.toData(cartItem))
                .map(this::toEntity);
    }

    @Override
    public Flux<CartItem> findAll(BigInteger userId) {
        return repository.findAllByUserId(userId)
                .doOnNext(p -> System.out.println("cartItem: " + p.toString()))
                .map(this::toEntity);
    }

    @Override
    public Mono<CartItem> findById(BigInteger id) {
        return repository.findById(id)
                .map(this::toEntity);
    }

    @Override
    public Mono<Void> removeProductFromCart(BigInteger id) {
        return repository.deleteById(id)
                .then();
    }

    @Override
    public Mono<Void> removeAll(BigInteger userId) {
        return repository.deleteAllByUserId(userId)
                .then();
    }

    @Override
    public Mono<Integer> count(BigInteger userId) {
        return repository.countByUserId(userId);
    }
}
