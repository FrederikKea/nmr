package com.nmr.demo.Repository;

import com.nmr.demo.Model.Booking;

import java.util.List;

public interface IBookingRepository {

    // CRUD operations
    void createBooking(Booking b);

    List<Booking> readAllBookings();

    Booking readOneBooking(int id);

    void updateBooking(Booking b);

    void deleteBooking(int id);
}
