package org.yesserm.service;

import org.hibernate.SessionFactory;
import org.yesserm.dao.GenericDAOImpl;
import org.yesserm.dao.IGenericDAO;

import java.util.List;
import java.util.Map;

public class GenericServiceImpl<T> implements IGenericService<T> {
    private final IGenericDAO<T> dao;
    private final Class<T> cl;
    SessionFactory session;

    public GenericServiceImpl(Class<T> cl, SessionFactory sessionFactory) {
        this.cl = cl;
        dao = new GenericDAOImpl<>(cl, sessionFactory);
        session = sessionFactory;
    }

    @Override
    public List<T> findAll() {
        return dao.query("from "+cl.getSimpleName(),null);
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
        return dao.save(object);
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }

    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        return dao.query(hsql, params);
    }
}
