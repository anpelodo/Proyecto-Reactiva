package com.anpelodo.usecase.product.productcrud;

import com.anpelodo.model.product.Product;
import com.anpelodo.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;


@RequiredArgsConstructor
public class ProductCrudUseCase {
    private final ProductRepository productRepo;

    public Mono<Product> saveProduct(Product product) {
        return this.productRepo.save(product);
    }

    public Mono<Product> updateProduct(Product product) {
/* // Only Update info data in database.
        return productRepo.findById(product.getId())
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found")))
                .flatMap(p -> {
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    p.setPrice(product.getPrice());
                    p.setImageUrl(product.getImageUrl());
                    return productRepo.update(p);
                });
*/
        return productRepo.existsById(product.getId())
                .map(exists -> Boolean.TRUE.equals(exists) ? product : Mono.empty())
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found")))
                .flatMap(p -> productRepo.update(product));
    }

    public Flux<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Mono<Product> findProductById(BigInteger id) {
        return productRepo.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found")));
    }

    public Flux<Product> findProductByName(String name) {
        return productRepo.findByName(name);
    }

    public Mono<Void> deleteProductById(BigInteger id) {
        return productRepo.deleteById(id);
    }
}
