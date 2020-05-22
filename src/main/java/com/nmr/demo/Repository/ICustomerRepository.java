package com.nmr.demo.Repository;

import com.nmr.demo.Model.Customer;

import java.sql.ResultSet;
import java.util.List;

public interface ICustomerRepository<T> {
    // CRUD operations
    void createCustomer(Customer c);

    List<Customer> readAllCustomers();

    Customer readOneCustomer(int id);

    boolean updateCustomer(Customer c);

    boolean deleteCustomer(int id);
}