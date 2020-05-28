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

            String queryPickup_table = "INSERT INTO nmr.pickup_table (pickup_streetname, pickup_city, pickup_zipcode)" +
                    "VALUES (?,?,?)";
            preparedStatement = conn.prepareStatement(queryPickup_table);
            preparedStatement.setString(1,booking.getPickupStreetname());
            preparedStatement.setString(2,booking.getPickupCity());
            preparedStatement.setString(3,booking.getPickupZipcode());
            preparedStatement.executeUpdate();


            String queryDropoff_table = "INSERT INTO nmr.dropoff_table (dropoff_streetname, dropoff_city, dropoff_zipcode)" +
                    "VALUES (?,?,?)";
            preparedStatement = conn.prepareStatement(queryDropoff_table);
            preparedStatement.setString(1,booking.getDropoffStreetname());
            preparedStatement.setString(2,booking.getDropoffCity());
            preparedStatement.setString(3,booking.getDropoffZipcode());
            preparedStatement.executeUpdate();


            String queryBookingTable = "INSERT INTO nmr.booking_table (booking_rentalstarttime,booking_rentalstoptime)" +
                    "VALUES (?,?)";
            preparedStatement = conn.prepareStatement(queryBookingTable);
            preparedStatement.setDate(1,java.sql.Date.valueOf(booking.getRentalStartTime()));
            preparedStatement.setDate(2,java.sql.Date.valueOf("1995-06-23"));
            preparedStatement.executeUpdate();

            String queryOrderTable = "INSERT INTO nmr.order_table(order_customer_id, order_extras_id, order_info_id, order_booking_id,order_pickup_id, order_dropoff_id,order_motorhome_id)" +
                    "VALUES((SELECT customer_id FROM nmr.customer_table WHERE customer_first_name = ?)," +
                    "(SELECT extras_id FROM nmr.extras_table WHERE extras_description = ?)," +
                    "(SELECT info_id FROM nmr.info_table WHERE info_comment = ?)," +
                    "(SELECT booking_id FROM nmr.booking_table WHERE booking_rentalstarttime = ?)," +
                    "(SELECT pickup_id FROM nmr.pickup_table WHERE pickup_streetname = ?)," +
                    "(SELECT dropoff_id FROM nmr.dropoff_table WHERE dropoff_streetname = ?)," +
                    "(SELECT motorhome_id FROM nmr.motorhome_table WHERE motorhome_modelname = ?))";
            preparedStatement = conn.prepareStatement(queryOrderTable);
            preparedStatement.setString(1, booking.getCustomers());
            preparedStatement.setString(2, booking.getExtras());
            preparedStatement.setString(3, booking.getComment());
            preparedStatement.setDate(4, java.sql.Date.valueOf(booking.getRentalStartTime()));
            preparedStatement.setString(5,booking.getPickupStreetname());
            preparedStatement.setString(6,booking.getDropoffStreetname());
            preparedStatement.setString(7,booking.getMotorhome());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    @Override
    public List<Booking> readAllBookings() {
        return null;
    }
*/



    @Override
    public List<Booking> readAllBookings() {
        List <Booking> allBookings = new ArrayList<>();
        try {
            String getAllBookings =
                    "SELECT order_table.order_id,\n" +
                            "customer_table.customer_first_name,\n" +
                            "motorhome_table.motorhome_modelname,\n" +
                            "booking_table.booking_rentalstarttime,\n" +
                            "booking_table.booking_rentalstoptime,\n" +
                            "motorhome_table.motorhome_modelname,\n" +
                            "pickup_table.pickup_streetname,\n" +
                            "pickup_table.pickup_city,\n" +
                            "pickup_table.pickup_zipcode,\n" +
                            "dropoff_table.dropoff_streetname,\n" +
                            "dropoff_table.dropoff_city,\n" +
                            "dropoff_table.dropoff_zipcode,\n" +
                            "extras_table.extras_description,\n" +
                            "info_table.info_comment\n" +
                            "FROM nmr.order_table\n" +
                            "INNER JOIN nmr.customer_table ON order_table.order_customer_id = customer_table.customer_id\n" +
                            "INNER JOIN nmr.booking_table ON order_table.order_booking_id = booking_table.booking_id\n" +
                            "INNER JOIN nmr.motorhome_table ON order_table.order_motorhome_id = motorhome_table.motorhome_id\n" +
                            "INNER JOIN nmr.info_table ON order_table.order_info_id = info_table.info_id\n" +
                            "INNER JOIN nmr.extras_table ON order_table.order_extras_id = extras_table.extras_id\n" +
                            "INNER JOIN nmr.pickup_table ON order_table.order_pickup_id = pickup_table.pickup_id\n" +
                            "INNER JOIN nmr.dropoff_table ON order_table.order_dropoff_id = dropoff_table.dropoff_id";

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
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)));
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