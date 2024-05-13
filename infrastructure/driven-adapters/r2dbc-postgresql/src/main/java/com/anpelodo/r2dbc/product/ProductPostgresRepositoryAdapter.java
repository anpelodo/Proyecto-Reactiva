package com.anpelodo.r2dbc.product;

import com.anpelodo.model.product.Product;
import com.anpelodo.model.product.gateways.ProductRepository;
import com.anpelodo.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Repository
public class ProductPostgresRepositoryAdapter
    extends ReactiveAdapterOperations<Product, ProductData, BigInteger, ProductPostgresRepository>
    implements ProductRepository
{
    public ProductPostgresRepositoryAdapter(ProductPostgresRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Product.class));
    }

    @Override
    public Mono<Product> save(Product product) {
        return this.repository.save(this.toData(product)).map(this::toEntity);
    }

    @Override
    public Mono<Product> update(Product product) {
        return this.repository.save(this.toData(product)).map(this::toEntity);
    }

    @Override
    public Mono<Product> findById(BigInteger id) {
        return this.repository.findById(id).map(this::toEntity);
    }

    @Override
    public Flux<Product> findByName(String name) {
        return this.repository.findAllByNameLikeIgnoreCase('%'+name+'%').map(this::toEntity);
    }

    @Override
    public Mono<Void> deleteById(BigInteger id) {
        return this.repository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsById(BigInteger id) {
        return this.repository.existsById(id);
    }
}
