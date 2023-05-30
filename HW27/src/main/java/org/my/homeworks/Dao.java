package org.my.homeworks;

import java.util.List;

public interface Dao<T, ID extends Integer> {

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> getAllEntities();

    T getEntityById(ID id);
}
