package com.nmr.demo.Controller;

import com.nmr.demo.Model.Booking;

import com.nmr.demo.Model.Motorhome;
import com.nmr.demo.Service.BookingService;
import com.nmr.demo.Service.CustomerService;
import com.nmr.demo.Service.ExtrasService;
import com.nmr.demo.Service.MotorhomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingController {

    BookingService bs = new BookingService();
    CustomerService cs = new CustomerService();
    MotorhomeService ms = new MotorhomeService();
    ExtrasService er = new ExtrasService();

    @GetMapping("/opretbooking")
    public String readAllModels(Model model) {
        System.out.println("controllerlayer");
        model.addAttribute("customers", cs.readAllCustomers());
        model.addAttribute("motorhomes", ms.readAllMotorhomes());
        model.addAttribute("extras", er.readAllExtras());
        return "opretbooking";
    }

    @PostMapping("/addBooking")
    public String createBooking (@ModelAttribute Booking booking) {
        bs.createBooking(booking);

        //return "redirect:/booking";
        return  "redirect:/opretbooking";
    }

    @GetMapping("oversigtbooking")
    public String showAllBookings(Model model) {
        model.addAttribute("bookings",bs.readAllBookings());
        return "oversigtbooking";
    }



}
