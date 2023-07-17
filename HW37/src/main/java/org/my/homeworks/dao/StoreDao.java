package org.my.homeworks.dao;

import java.util.List;

public interface StoreDao<T> {
    void add();
    T getById(int id);
    List<T> getAllEntities();
}
