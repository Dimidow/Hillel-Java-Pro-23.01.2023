package org.my.homeworks.dao;

public interface StoreDao<T> {

    void add(T item);

    void delete(int id);

    T getById(int id);
}
