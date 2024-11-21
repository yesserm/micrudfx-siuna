package org.yesserm.dao;

import java.util.List;
import java.util.Map;

public interface IGenericDAO<T> {
    // get using integer id
    public T get(Class<T> cl, Integer id);

    // get using long id
    T get(Class<T> cl, Long id);

    // method to save
    public T save(T object);

    // method to update
    public void update(T object);

    // method to delete
    public void delete(T object);

    // method to list
    public List<T> query(String hsql, Map<String, Object> params);
}

