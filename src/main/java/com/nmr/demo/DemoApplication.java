package com.nmr.demo;

import com.nmr.demo.Model.Booking;
import com.nmr.demo.Service.BookingService;
import com.nmr.demo.Util.DatabaseConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        /*
        BookingService bookingService = new BookingService();
         */

        /*
        Booking booking = new Booking();
        booking = bookingService.readOneBooking(1);
        System.out.println(booking.toString());*/


    }
}

//TEST KODE FOR FORBINDELSE TIL DB

//        Connection mycon = com.nmr.demo.Util.DatabaseConnectionManager.getDatabaseConnection();
//
//        Statement myStatement;
//        //test of database, prints out all customer names
//        try {
//            myStatement = mycon.createStatement();
//            String getAllCustomers = "SELECT * FROM nmr.customer_table";
//            ResultSet allCustomers = myStatement.executeQuery(getAllCustomers);
//            while (allCustomers.next()) {
//                System.out.println(
//                        "Kunde-id : " + allCustomers.getString("customer_first_name")
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

