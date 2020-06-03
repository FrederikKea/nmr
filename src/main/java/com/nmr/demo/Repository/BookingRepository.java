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

            String queryInfoTable = "INSERT IGNORE INTO nmr.info_table (info_description) " +
                    "VALUES (?)";
            preparedStatement = conn.prepareStatement(queryInfoTable);
            preparedStatement.setString(1,booking.getComment());
            preparedStatement.executeUpdate();

           /* String queryPickup_table = "INSERT IGNORE INTO nmr.pickup_table (pickup_streetname, pickup_city, pickup_zipcode)" +
                    "VALUES (?,?,?)";
            preparedStatement = conn.prepareStatement(queryPickup_table);
            preparedStatement.setString(1,booking.getPickupStreetname());
            preparedStatement.setString(2,booking.getPickupCity());
            preparedStatement.setString(3,booking.getPickupZipcode());
            preparedStatement.executeUpdate();


            String queryDropoff_table = "INSERT IGNORE INTO nmr.dropoff_table (dropoff_streetname, dropoff_city, dropoff_zipcode)" +
                    "VALUES (?,?,?)";
            preparedStatement = conn.prepareStatement(queryDropoff_table);
            preparedStatement.setString(1,booking.getDropoffStreetname());
            preparedStatement.setString(2,booking.getDropoffCity());
            preparedStatement.setString(3,booking.getDropoffZipcode());
            preparedStatement.executeUpdate();


*/

            String queryPickup_table = "INSERT IGNORE INTO nmr.address_table (address_streetname, address_city, address_zipcode, address_country)" +
                    "VALUES (?,?,?,?)";
            preparedStatement = conn.prepareStatement(queryPickup_table);
            preparedStatement.setString(1,booking.getPickupStreetname());
            preparedStatement.setString(2,booking.getPickupCity());
            preparedStatement.setString(3,booking.getPickupZipcode());
            preparedStatement.setString(4,"Denmark");
            preparedStatement.executeUpdate();


            String queryDropoff_table = "INSERT IGNORE INTO nmr.address_table (address_streetname, address_city, address_zipcode, address_country)" +
                    "VALUES (?,?,?,?)";
            preparedStatement = conn.prepareStatement(queryDropoff_table);
            preparedStatement.setString(1,booking.getDropoffStreetname());
            preparedStatement.setString(2,booking.getDropoffCity());
            preparedStatement.setString(3,booking.getDropoffZipcode());
            preparedStatement.setString(4,"Denmark");
            preparedStatement.executeUpdate();

            String queryBookingTable = "INSERT IGNORE INTO nmr.booking_table (booking_start_date,booking_stop_date)" +
                    "VALUES (?,?)";
            preparedStatement = conn.prepareStatement(queryBookingTable);
            preparedStatement.setDate(1,java.sql.Date.valueOf(booking.getRentalStartTime()));
            preparedStatement.setDate(2,java.sql.Date.valueOf(booking.getRentalStopTime()));
            preparedStatement.executeUpdate();

            String queryOrderTable = "INSERT INTO nmr.order_table(order_customer_id, order_extras_id, order_info_id, order_booking_id, order_pickup_id, order_dropoff_id, order_motorhome_id)" +
                    "VALUES((SELECT customer_id FROM nmr.customer_table WHERE customer_first_name = ?)," +
                    "(SELECT extras_id FROM nmr.extras_table WHERE extras_description = ?)," +
                    "(SELECT info_id FROM nmr.info_table WHERE info_description = ?)," +
                    "(SELECT booking_id FROM nmr.booking_table WHERE booking_start_date = ? AND booking_stop_date =?)," +
                    "(SELECT address_id FROM nmr.address_table WHERE address_streetname = ?)," +
                    "(SELECT address_id FROM nmr.address_table WHERE address_streetname = ?)," +
                    "(SELECT motorhome_id FROM nmr.motorhome_table WHERE motorhome_modelname = ?))";
            preparedStatement = conn.prepareStatement(queryOrderTable);
            preparedStatement.setString(1, booking.getCustomers());
            preparedStatement.setString(2, booking.getExtras());
            preparedStatement.setString(3, booking.getComment());
            preparedStatement.setDate(4, java.sql.Date.valueOf(booking.getRentalStartTime()));
            preparedStatement.setDate(5,java.sql.Date.valueOf(booking.getRentalStopTime()));
            preparedStatement.setString(6,booking.getPickupStreetname());
            preparedStatement.setString(7,booking.getDropoffStreetname());
            preparedStatement.setString(8,booking.getMotorhome());
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
                    "SELECT order_table.order_id, " +
                            "customer_table.customer_first_name, " +
                            "motorhome_table.motorhome_modelname, " +
                            "booking_table.booking_start_date, " +
                            "booking_table.booking_stop_date, " +
                            "a_t.address_streetname, " +
                            "a_t.address_city, " +
                            "a_t.address_zipcode, " +
                            "a_t2.address_streetname, " +
                            "a_t2.address_city, " +
                            "a_t2.address_zipcode, " +
                            "extras_table.extras_description, " +
                            "info_table.info_description " +
                            "FROM nmr.order_table " +
                            "INNER JOIN nmr.customer_table ON order_table.order_customer_id = customer_table.customer_id " +
                            "INNER JOIN nmr.booking_table ON order_table.order_booking_id = booking_table.booking_id " +
                            "INNER JOIN nmr.motorhome_table ON order_table.order_motorhome_id = motorhome_table.motorhome_id " +
                            "INNER JOIN nmr.info_table ON order_table.order_info_id = info_table.info_id " +
                            "INNER JOIN nmr.extras_table ON order_table.order_extras_id = extras_table.extras_id " +
                            "INNER JOIN nmr.address_table AS a_t ON order_table.order_pickup_id = a_t.address_id " +
                            "INNER JOIN nmr.address_table AS a_t2 ON order_table.order_dropoff_id = a_t2.address_id; ";
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
    public Booking readOneBooking(int order_id) {
        Booking bookingToReturn = new Booking();
        try{
            String readOneBooking =
                    "SELECT order_table.order_id, " +
                    "customer_table.customer_first_name, " +
                    "motorhome_table.motorhome_modelname, " +
                    "booking_table.booking_start_date, " +
                    "booking_table.booking_stop_date, " +
                    "a_t.address_streetname, " +
                    "a_t.address_city, " +
                    "a_t.address_zipcode, " +
                    "a_t2.address_streetname, " +
                    "a_t2.address_city, " +
                    "a_t2.address_zipcode, " +
                    "extras_table.extras_description, " +
                    "info_table.info_description " +
                    "FROM nmr.order_table " +
                    "INNER JOIN nmr.customer_table ON order_table.order_customer_id = customer_table.customer_id " +
                    "INNER JOIN nmr.booking_table ON order_table.order_booking_id = booking_table.booking_id " +
                    "INNER JOIN nmr.motorhome_table ON order_table.order_motorhome_id = motorhome_table.motorhome_id " +
                    "INNER JOIN nmr.info_table ON order_table.order_info_id = info_table.info_id " +
                    "INNER JOIN nmr.extras_table ON order_table.order_extras_id = extras_table.extras_id " +
                    "INNER JOIN nmr.address_table AS a_t ON order_table.order_pickup_id = a_t.address_id " +
                    "INNER JOIN nmr.address_table AS a_t2 ON order_table.order_dropoff_id = a_t2.address_id " +
                    "WHERE order_id=?; ";

            PreparedStatement myStatement = conn.prepareStatement(readOneBooking);
            myStatement.setInt(1,order_id);
            ResultSet rs = myStatement.executeQuery();
            while (rs.next()) {
                bookingToReturn = new Booking(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toString(),
                        rs.getDate(5).toString(),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingToReturn;
    }

    @Override
    public void updateBooking(Booking b) {
        try {
            String query = "UPDATE nmr.order_table " +
                    "INNER JOIN nmr.customer_table ON order_table.order_customer_id = customer_table.customer_id " +
                    "INNER JOIN nmr.motorhome_table ON order_table.order_motorhome_id = motorhome_table.motorhome_id " +
                    "INNER JOIN nmr.booking_table ON order_table.order_booking_id = booking_table.booking_id " +
                    "INNER JOIN nmr.address_table AS a_t ON order_table.order_pickup_id = a_t.address_id " +
                    "INNER JOIN nmr.address_table AS a_t2 ON order_table.order_dropoff_id = a_t2.address_id " +
                    "INNER JOIN nmr.info_table ON order_table.order_info_id = info_table.info_id " +
                    "INNER JOIN nmr.extras_table ON order_table.order_extras_id = extras_table.extras_id " +
                    "SET customer_table.customer_first_name=?, motorhome_table.motorhome_modelname =?, booking_table.booking_start_date=?, booking_table.booking_stop_date=?, a_t.address_streetname=?, a_t.address_city=?, a_t.address_zipcode=?, a_t2.address_streetname=?, a_t2.address_city=?, a_t2.address_zipcode=?, extras_table.extras_description=?, info_table.info_description=? " +
                    "WHERE order_table.order_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, b.getCustomers());
            preparedStatement.setString(2, b.getMotorhome());
            preparedStatement.setDate(3, java.sql.Date.valueOf(b.getRentalStartTime()));
            preparedStatement.setDate(4, java.sql.Date.valueOf(b.getRentalStopTime()));
            preparedStatement.setString(5, b.getPickupStreetname());
            preparedStatement.setString(6, b.getPickupCity());
            preparedStatement.setString(7, b.getPickupZipcode());
            preparedStatement.setString(8, b.getDropoffStreetname());
            preparedStatement.setString(9, b.getDropoffCity());
            preparedStatement.setString(10, b.getDropoffZipcode());
            preparedStatement.setString(11, b.getExtras());
            preparedStatement.setString(12, b.getComment());
            preparedStatement.setInt(13, b.getOrder_id());

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException s){
            s.printStackTrace();
        }
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