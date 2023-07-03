package org.my.homeworks.HW36.dao;

import java.util.List;

public interface StoreDao<T> {
    void add(T item);
    T getById(int id);
    List<T> getAllEntities();
}
