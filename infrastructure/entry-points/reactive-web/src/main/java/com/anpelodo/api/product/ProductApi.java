package com.anpelodo.api.product;

import com.anpelodo.model.product.Product;
import com.anpelodo.usecase.product.productcrud.ProductCrudUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Log4j2
public class ProductApi {
    private final ProductCrudUseCase useCase;

    @GetMapping("")
    public Flux<Product> getAllProducts() {
        log.info("Getting all products");
        return useCase.findAllProducts();
    }

    @GetMapping(path = "product/{id}")
    public Mono<Product> getProductById(@PathVariable("id") BigInteger id) {
        log.info("Getting product by id: {}", id);

        return useCase.findProductById(id)
                .onErrorReturn(Product.builder().build());
    }

    @GetMapping(path = "product")
    public Flux<Product> queryProduct(@RequestParam("name") String name) {
        log.info("Search product by name: {} ", name);
        return useCase.findProductByName(name);
    }

    @PostMapping(path = "/")
    public Mono<Product> createProduct(@RequestBody Product product) {
        product.setId(null);

        log.info("Creating product: {}", product);
        return useCase.saveProduct(product);
    }

    @PutMapping(path = "product/{id}")
    public Mono<Product> updateProduct(@PathVariable("id") BigInteger id, @RequestBody Product product) {
        product.setId(id);

        log.info("Updating product: {}", product);
        return useCase.updateProduct(product);
    }

    @DeleteMapping(path = "product/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") BigInteger id) {
        log.info("Deleting product with id: {}", id);
        return useCase.deleteProductById(id);
    }
}
