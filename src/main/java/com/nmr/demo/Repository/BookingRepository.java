package com.nmr.demo.Repository;

import com.nmr.demo.Model.Booking;
import com.nmr.demo.Util.DatabaseConnectionManager;

import java.sql.*;
import java.util.List;

public class BookingRepository implements IBookingRepository {

    private Connection conn;
    private PreparedStatement preparedStatement;

    public BookingRepository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public void createBooking(Booking b) {

    }

    @Override
    public List<Booking> readAllBookings() {
        return null;
    }

    @Override
    public Booking readOneBooking(int id) {
        return null;
    }

    @Override
    public void updateBooking(Booking b) {

    }

    @Override
    public void deleteBooking(int id) {

    }
}