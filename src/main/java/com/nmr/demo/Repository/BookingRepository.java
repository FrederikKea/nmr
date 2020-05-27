package com.nmr.demo.Repository;

import com.nmr.demo.Model.Booking;
import com.nmr.demo.Util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
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
        List <Booking> allBookings = new ArrayList<>();
        try {
            String getAllBookings =
                    "SELECT \n" +
                            "booking_table.booking_id,\n" +
                            "customer_table.customer_first_name,\n" +
                            "motorhome_table.motorhome_modelname,\n" +
                            "booking_rentalstarttime,\n" +
                            "booking_rentalstoptime,\n" +
                            "booking_pickup_id,\n" +
                            "booking_dropoff_id,\n" +
                            "info_table.info_comment\n" +
                            "FROM nmr.booking_table\n" +
                            "INNER JOIN nmr.customer_table ON booking_table.booking_id = customer_table.customer_id\n" +
                            "INNER JOIN nmr.motorhome_table ON booking_table.booking_id = motorhome_table.motorhome_id\n" +
                            "INNER JOIN nmr.info_table ON booking_table.booking_id = info_table.info_id;\n";
            PreparedStatement myStatement = conn.prepareStatement(getAllBookings);
            ResultSet rs = myStatement.executeQuery();
            while (rs.next()) {
                allBookings.add(new Booking(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBookings;
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
        try {
            String sql = "DELETE FROM nmr.booking_table WHERE booking_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}