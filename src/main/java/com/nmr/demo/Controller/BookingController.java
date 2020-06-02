package com.nmr.demo.Controller;

import com.nmr.demo.Model.Booking;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Model.Motorhome;
import com.nmr.demo.Service.BookingService;
import com.nmr.demo.Service.CustomerService;
import com.nmr.demo.Service.ExtrasService;
import com.nmr.demo.Service.MotorhomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookingController {

    BookingService bs = new BookingService();
    CustomerService cs = new CustomerService();
    MotorhomeService ms = new MotorhomeService();
    ExtrasService es = new ExtrasService();


    @GetMapping("opretbooking")
    public String readAllModels(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("customers", cs.readAllCustomers());
        model.addAttribute("motorhomes", ms.readAllMotorhomes());
        model.addAttribute("extras", es.readAllExtras());
        return "opretbooking";
    }

    @PostMapping("/addBooking")
    public String createBooking(@Valid @ModelAttribute Booking booking, BindingResult binding, Model model){
        String validateandcreateB = bs.validateandcreateBooking(booking, binding, model);
        return validateandcreateB;
    }

        @GetMapping("/editBooking/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model){
        Booking booking = bs.readOneBooking(id);
        model.addAttribute("booking", booking);
        model.addAttribute("customers", cs.readAllCustomers());
        model.addAttribute("motorhomes", ms.readAllMotorhomes());
        model.addAttribute("extras", es.readAllExtras());
        return "redigerbooking";
    }

    @PostMapping("/updateBooking/{id}")
    public String updateBooking(@PathVariable("id") int id, @Valid @ModelAttribute Booking booking, BindingResult binding, Model model){
        booking.setOrder_id(id);
        String validateandupdate = bs.validateandupdateBooking(booking, binding, model);
        return validateandupdate;
    }


    @GetMapping("oversigtbooking")
    public String showAllBookings(Model model) {
        model.addAttribute("bookings",bs.readAllBookings());
        return "oversigtbooking";
    }


    //skal slettets
    @GetMapping("test2")
    public String test2 () {
        return "test2";
    }

}
