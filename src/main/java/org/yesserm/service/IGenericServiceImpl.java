package org.yesserm.service;

import java.util.List;
import java.util.Map;

public class IGenericServiceImpl<T> implements IGenericService<T> {
    @Override
    public List<T> findAll() {
        return List.of();
    }

    @Override
    public T getById(long id) {
        return null;
    }

    @Override
    public T get(Class<T> cl, Integer id) {
        return null;
    }

    @Override
    public T get(Class<T> cl, Long id) {
        return null;
    }

    @Override
    public T save(T object) {
        return null;
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }

    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        return List.of();
    }
}
