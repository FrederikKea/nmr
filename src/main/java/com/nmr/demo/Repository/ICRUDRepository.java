package com.nmr.demo.Repository;

import java.util.List;

public interface ICRUDRepository<T> {
    // CRUD operations
    void create(T t);

    List<T> readAll();

    T read(int id);

    boolean update(T t);

    boolean delete(int id);
}