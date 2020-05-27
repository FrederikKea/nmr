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
    public void createBooking(Booking booking) {
        try {

            String queryInfoTable = "INSERT INTO nmr.info_table (info_comment) " +
                    "VALUES (?)";
            preparedStatement = conn.prepareStatement(queryInfoTable);
            preparedStatement.setString(1,booking.getComment());
            preparedStatement.executeUpdate();

            String queryPickup_table = "INSERT INTO nmr.pickup_table (pickup_streetname)" +
                    "VALUES (?)";
            preparedStatement = conn.prepareStatement(queryPickup_table);
            preparedStatement.setString(1,booking.getAddressRentalStart());
            preparedStatement.executeUpdate();

            String queryDropoff_table = "INSERT INTO nmr.dropoff_table (dropoff_streetname)" +
                    "VALUES (?)";
            preparedStatement = conn.prepareStatement(queryDropoff_table);
            preparedStatement.setString(1,booking.getAddressRentalStop());
            preparedStatement.executeUpdate();

            String queryBookingTable = "INSERT INTO nmr.booking_table (booking_motorhome_id, booking_pickup_id, booking_dropoff_id, booking_rentalstarttime,booking_rentalstoptime)" +
                    "VALUES((SELECT motorhome_id FROM nmr.motorhome_table WHERE motorhome_modelname = ?)," +
                    "(SELECT pickup_id FROM nmr.pickup_table WHERE pickup_streetname = ?)," +
                    "(SELECT dropoff_id FROM nmr.dropoff_table WHERE dropoff_streetname = ?)," +
                    "?,?)";


            preparedStatement = conn.prepareStatement(queryBookingTable);
            preparedStatement.setString(1,booking.getMotorhome());
            //preparedStatement.setString(1,"Sunlight V 66");
            preparedStatement.setString(2,booking.getAddressRentalStart());
            //preparedStatement.setString(2,"Æblehavevej 231");
            preparedStatement.setString(3,booking.getAddressRentalStop());
            //preparedStatement.setString(3,"Kiwivejen 24");
            //fra customer
            //preparedStatement.setDate(6,java.sql.Date.valueOf(customer.getDob()));
            //preparedStatement.setDate(2,java.sql.Date.valueOf(booking.getRentalStartTime()));
            preparedStatement.setDate(4,java.sql.Date.valueOf("1995-06-22"));
            //preparedStatement.setDate(3,java.sql.Date.valueOf(booking.getRentalStopTime()));
            preparedStatement.setDate(5,java.sql.Date.valueOf("1995-06-22"));
            preparedStatement.executeUpdate();

            String queryOrderTable = "INSERT INTO nmr.order_table(order_customer_id, order_extras_id, order_info_id, order_booking_id)" +
                    "VALUES((SELECT customer_id FROM nmr.customer_table WHERE customer_first_name = ?)," +
                    "(SELECT extras_id FROM nmr.extras_table WHERE extras_description = ?)," +
                    "(SELECT info_id FROM nmr.info_table WHERE info_comment = ?)," +
                    "(SELECT booking_id FROM nmr.booking_table WHERE booking_rentalstarttime = ?))";
            preparedStatement = conn.prepareStatement(queryOrderTable);
            preparedStatement.setString(1, booking.getCustomers());
            //preparedStatement.setString(1, "David");
            preparedStatement.setString(2, booking.getExtras());
            //preparedStatement.setString(3, booking.getComment());
            preparedStatement.setString(3, "test2");
            //preparedStatement.setDate(4, java.sql.Date.valueOf(booking.getRentalStartTime()));
            preparedStatement.setDate(4, java.sql.Date.valueOf("2021-12-16"));
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Booking> readAllBookings() {
        List <Booking> allBookings = new ArrayList<>();
        try {
            String getAllBookings =
                    "SELECT " +
                            "booking_table.booking_id,\n" +
                            "customer_table.customer_first_name,\n" +
                            "motorhome_table.motorhome_modelname,\n" +
                            "booking_rentalstarttime,\n" +
                            "booking_rentalstoptime,\n" +
                            "booking_pickup_id,\n" +
                            "booking_dropoff_id,\n" +
                            "extras_table.extras_description,\n" +
                            "info_table.info_comment\n" +
                            "FROM nmr.booking_table\n" +
                            "INNER JOIN nmr.customer_table ON booking_table.booking_id = customer_table.customer_id\n" +
                            "INNER JOIN nmr.motorhome_table ON booking_table.booking_id = motorhome_table.motorhome_id\n" +
                            "INNER JOIN nmr.info_table ON booking_table.booking_id = info_table.info_id\n" +
                            "INNER JOIN nmr.extras_table ON booking_table.booking_id = extras_table.extras_id";
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
                        rs.getString(8),
                        rs.getString(9)));
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