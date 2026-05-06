package DAO;

import java.io.Serializable;

public interface DAO<T> {

    public void save(T t);

    public T update(T t);

    public void delete(T t);

    public T get(Serializable id);

    public void begin();
    public void commit();
}