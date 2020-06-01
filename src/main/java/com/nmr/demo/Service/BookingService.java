package com.nmr.demo.Service;

import com.nmr.demo.Model.Booking;
import com.nmr.demo.Model.Customer;
import com.nmr.demo.Repository.BookingRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    BookingRepository br = new BookingRepository();

    public void createBooking(Booking booking){
        br.createBooking(booking);
    }

    public String validateandcreateBooking(Booking booking, BindingResult binding, Model model){
        if (binding.hasErrors()){
            return "opretbooking";
        }
        br.createBooking(booking);
        model.addAttribute("booking" , this.readAllBookings());
        return ("redirect:/oversigtbooking");
    }


    public void updateBooking(Booking b){
        br.updateBooking(b);
    }

    public String validateandupdateBooking(Booking booking, BindingResult binding, Model model){
        if (binding.hasErrors()){
            return "redigerbooking";
        }
        br.updateBooking(booking);
        model.addAttribute("booking" , this.readAllBookings());
        return ("redirect:/oversigtbooking");
    }

    public List<Booking> readAllBookings() {
        List <Booking> allBookings = new ArrayList<>();
        allBookings = br.readAllBookings();
        return allBookings;
    }
    public Booking readOneBooking(int id){
        Booking booking = new Booking();
        booking = br.readOneBooking(id);
        return booking;
    }
}
