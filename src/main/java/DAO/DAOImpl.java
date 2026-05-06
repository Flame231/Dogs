package DAO;

import jakarta.persistence.EntityManager;
import utils.HibernateUtil;

import java.io.Serializable;

public class DAOImpl<T> implements DAO<T> {
    EntityManager em = HibernateUtil.getEntityManager();
    Class<T> tlass;

    public DAOImpl(Class<T> tlass) {
        this.tlass = tlass;
    }

    @Override
    public void save(T t) {
        begin();
        em.persist(t);
        commit();
    }

    @Override
    public T update(T t) {
        begin();
        em.merge(t);
        commit();
        return t;
    }

    @Override
    public void delete(T t) {
        begin();
       em.remove(t);
       commit();
    }

    @Override
    public T get(Serializable id) {
       return em.find(tlass, id);
    }
    @Override
    public void begin(){
        em.getTransaction().begin();
    }
    @Override
    public void commit(){
        em.getTransaction().commit();
    }
}
