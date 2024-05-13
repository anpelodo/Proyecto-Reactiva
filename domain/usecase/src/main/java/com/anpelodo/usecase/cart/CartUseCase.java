package com.anpelodo.usecase.cart;

import com.anpelodo.model.cart.CartDetails;
import com.anpelodo.model.cart.CartItem;
import com.anpelodo.model.cart.CartItemNotExist;
import com.anpelodo.model.cart.gateways.CartRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RequiredArgsConstructor
public class CartUseCase {
    private final CartRepository cartRepo;

    public Mono<CartItem> addProductToCart(CartItem cartItem){
        return cartRepo.save(cartItem);
    }

    public Mono<Void> updateQuantity(CartItem cartItem, Integer quantity){
        if(quantity < 0) {
            return Mono.error(new IllegalArgumentException("Quantity must be greater than 0"));
        }

        if(quantity == 0) {
            return cartRepo.removeProductFromCart(cartItem);
        }

        return cartRepo.exist(cartItem)
                .flatMap(exist -> {
                    if(Boolean.FALSE.equals(exist)){
                        return Mono.error(new CartItemNotExist(cartItem));
                    }

                    cartItem.setQuantity(quantity);
                    return cartRepo.update(cartItem);
                })
                .then();
    }

    public Mono<Void> removeProductFromCart(CartItem cartItem){
        return cartRepo.removeProductFromCart(cartItem);
    }

    public Mono<Void> emptyCart(BigInteger userId){
        return cartRepo.removeAll(userId);
    }

    public Mono<Integer> count(BigInteger userId){
        return cartRepo.count(userId);
    }

    public Flux<CartItem> getCart(BigInteger userId){
        return cartRepo.findAll(userId);
    }

    public Mono<CartDetails> getCartDetails(BigInteger userId, double shipping){
        return cartRepo.findAll(userId)
                .collectList()
                .map(list -> new CartDetails(list, shipping));
    }
}
