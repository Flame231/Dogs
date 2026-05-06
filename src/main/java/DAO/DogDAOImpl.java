package DAO;

import jakarta.persistence.EntityManager;
import models.Dog;
import utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class DogDAOImpl extends DAOImpl<Dog> implements DogDAO {

    public DogDAOImpl() {
        super(Dog.class);
    }

    @Override
    public void save(Dog obj) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Dog update(Dog obj) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
        return null;
    }

    @Override
    public void delete(Dog obj) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Dog get(Serializable id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Dog obj1 = em.find(Dog.class, id);
        return obj1;
    }

    @Override
    public List<Dog> getAllDogs(int currentPage, int dogsPerPage) {
        return em.createQuery("From Dog", Dog.class)
                .setFirstResult((currentPage-1) * dogsPerPage).setMaxResults(dogsPerPage)
                .getResultList();
    }

    @Override
    public Integer getDogsCount() {
        return em.createQuery("SELECT COUNT(d) From Dog d", Long.class).getSingleResult().intValue();
    }
}
