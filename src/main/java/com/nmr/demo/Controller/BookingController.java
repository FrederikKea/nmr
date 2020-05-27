package com.nmr.demo.Controller;

import com.nmr.demo.Service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

    BookingService br = new BookingService();


    @GetMapping("oversigtbooking")
    public String showAllBookings(Model model) {
        model.addAttribute("bookings",br.readAllBookings());
        return "oversigtbooking";
    }



}
