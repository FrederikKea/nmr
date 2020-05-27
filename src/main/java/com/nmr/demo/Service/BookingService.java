package com.nmr.demo.Service;

import com.nmr.demo.Model.Booking;
import com.nmr.demo.Model.Customer;
import com.nmr.demo.Repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    BookingRepository br = new BookingRepository();

    public void createBooking(Booking booking){
        br.createBooking(booking);
    }

    public List<Booking> readAllBookings() {
        List <Booking> allBookings = new ArrayList<>();
        allBookings = br.readAllBookings();
        return allBookings;
    }
}
