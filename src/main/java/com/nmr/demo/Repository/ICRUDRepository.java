package com.nmr.demo.Repository;

import com.nmr.demo.Model.Customer;

import java.sql.ResultSet;
import java.util.List;

public interface ICRUDRepository<T> {
    // CRUD operations
    void create(T t);

    ResultSet readCustomers();

    T read(int id);

    boolean update(T t);

    boolean delete(int id);
}