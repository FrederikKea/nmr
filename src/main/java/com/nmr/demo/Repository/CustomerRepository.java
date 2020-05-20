package com.nmr.demo.Repository;

import com.nmr.demo.Model.Customer;

import java.util.List;

public class CustomerRepository implements ICRUDRepository<Customer> {

    @Override
    public void create(Customer c) {}

    @Override
    public List<Customer> readAll()  {
        return null;
    }

    @Override
    public Customer read(int id)  {
        return null;
    }

    @Override
    public boolean update(Customer c) {
        return false;
    }

    @Override
    public boolean delete(int id) { return false; }


    public void createCustomer(){

    }

    public void readOneCustomer(){

    }

    public void readCustomers(){

    }

    public void udpateCustomer(){

    }

    public void deleteCustomer(){

    }
}
