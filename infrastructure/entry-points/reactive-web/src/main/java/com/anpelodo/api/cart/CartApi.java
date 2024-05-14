package com.anpelodo.api.cart;

import com.anpelodo.model.cart.CartDetails;
import com.anpelodo.model.cart.CartItem;
import com.anpelodo.usecase.cart.CartUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "/api/v1/cart", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Log4j2
public class CartApi {
    private final CartUseCase useCase;

    @PostMapping("")
    public Mono<CartItem> addProductToCart(@RequestBody CartItem cartItem) {
        log.info("Creating cart item: {}", cartItem.toString());
        return useCase.addProductToCart(cartItem);
    }

    @PutMapping("")
    public Mono<Void> updateCartItemQuantity(@RequestBody CartItem cartItem) {
        log.info("Updating cart item:  {}", cartItem.toString());
        return useCase.updateQuantity(cartItem, cartItem.getQuantity());
    }

    @GetMapping("")
    public Flux<CartItem> getAllCartItems(@RequestParam("user-id") BigInteger userId) {
        log.info("Getting all cart items");
        return useCase.getCart(userId);
    }

    @DeleteMapping("{id}")
    public Mono<Void> removeCartItem(@PathVariable("id") BigInteger id) {
        log.info("Deleting cart item: {}", id);
        return useCase.removeProductFromCart(id);
    }

    @DeleteMapping("/user/{userId}")
    public Mono<Void> clearCart(@PathVariable("userId") BigInteger userId) {
        log.info("Clearing cart for user: {}", userId);
        return useCase.clearCart(userId);
    }

    @GetMapping("count")
    public Mono<Integer> getCartItemsCount(@RequestParam("user-id") BigInteger userId) {
        log.info("Getting cart items count for user: {}", userId);
        return useCase.count(userId);
    }

    @GetMapping("/details")
    public Mono<CartDetails> getCartDetails(
            @RequestParam(value = "user-id") BigInteger userId,
            @RequestParam(value = "with-shipping", required = false, defaultValue = "false") boolean withShipping
    ) {
        log.info("Getting cart details for user: {}\nShipping: {}", userId, withShipping);
        return useCase.getCartDetails(userId, withShipping);
    }
}
