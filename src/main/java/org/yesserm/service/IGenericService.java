package org.yesserm.service;

import org.yesserm.dao.IGenericDAO;

import java.util.List;

public interface IGenericService<T> extends IGenericDAO<T> {
    List<T> findAll();
    T getById(long id);
}

