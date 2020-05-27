package com.nmr.demo.Service;

import com.nmr.demo.Model.Booking;
import com.nmr.demo.Repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    BookingRepository br = new BookingRepository();


    public List<Booking> readAllBookings() {
        List <Booking> allBookings = new ArrayList<>();
        allBookings = br.readAllBookings();
        return allBookings;
    }
}
