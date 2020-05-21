package com.nmr.demo.Repository;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Util.DatabaseConnectionManager;

import java.sql.*;
import java.util.List;

public class CustomerRepository implements ICRUDRepository {

    private Connection conn;

    public CustomerRepository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public void create(Object o) {

    }



    @Override
    public ResultSet readCustomers() {
        try {
            String query = "SELECT customer_table.customer_id,customer_table.customer_first_name,customer_table.customer_last_name, \n" +
                "address_table.address_streetname, address_table.address_city, address_table.address_zipcode,address_table.address_country,\n" +
                "email_table.email,\n" +
                "phonenumber_table.phonenumber,\n" +
                "customer_dob,customer_driverslicense_id\n" +
                "FROM customer_table\n" +
                "INNER JOIN address_table ON customer_table.customer_id = address_table.address_id \n" +
                "INNER JOIN email_table ON customer_table.customer_id = email_table.email_id\n" +
                "INNER JOIN phonenumber_table ON customer_table.customer_id = phonenumber_table.phonenumber_id";

            Statement stmt = conn.createStatement();

            //skal laves smarter i forhold til at den skal vide den bruger nmr databasen

            //PreparedStatement ps = conn.prepareStatement(query);
            //ResultSet rs = ps.executeQuery();

            ResultSet rs = stmt.executeQuery("use nmr");
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Object read(int id) {
        return null;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
