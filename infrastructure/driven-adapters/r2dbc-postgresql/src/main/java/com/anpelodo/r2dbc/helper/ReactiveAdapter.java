package com.anpelodo.r2dbc.helper;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.repository.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

public abstract class ReactiveAdapter<E, D, I, R extends Repository<D, I>> {
    private final Class<D> dataClass;
    private final Function<D, E> toEntityFn;
    protected R repository;
    protected ObjectMapper mapper;

    protected ReactiveAdapter(R repository, ObjectMapper mapper, Function<D, E> toEntityFn) {
        this.repository = repository;
        this.mapper = mapper;
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.dataClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
        this.toEntityFn = toEntityFn;
    }

    protected D toData(E entity) {
        return mapper.map(entity, dataClass);
    }

    protected E toEntity(D data) {
        return data != null ? toEntityFn.apply(data) : null;
    }
}