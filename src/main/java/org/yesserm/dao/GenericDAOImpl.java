package org.yesserm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class GenericDAOImpl<T> implements IGenericDAO<T> {
   private final SessionFactory sessionFactory;

   public GenericDAOImpl(Class<T> cl, SessionFactory sessionFactory) {
       this.sessionFactory = sessionFactory;
       if (sessionFactory == null)
           throw new RuntimeException("The Session Factory is null!!!");
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
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }

    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hsql);
        if (params != null) {
            for (String i : params.keySet()) {
                query.setParameter(i, params.get(i));
            }
        }

        List<T> result = null;
        if ((!hsql.toUpperCase().contains("DELETE"))
                && (!hsql.toUpperCase().contains("UPDATE"))
                && (!hsql.toUpperCase().contains("INSERT"))) {
            result = query.list();
        }
        session.getTransaction().commit();

        return result;
    }
}
