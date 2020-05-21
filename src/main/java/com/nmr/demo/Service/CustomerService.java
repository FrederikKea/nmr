package com.nmr.demo.Service;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Repository.CustomerRepository;
import com.nmr.demo.Util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    CustomerRepository cr = new CustomerRepository();

    public void createCustomer(){

    }

    public void readOneCustomer(){

    }

    public List<Customer> readCustomers() throws SQLException{
        List <Customer> allCustomers = new ArrayList<>();
        System.out.println("Servicelayer");
        try {
            ResultSet rs = cr.readCustomers();
            while (rs.next()) {
                allCustomers.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;

    }

    public void udpateCustomer(){

    }

    public void deleteCustomer(){

    }
}
