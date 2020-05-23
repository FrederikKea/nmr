package com.nmr.demo.Controller;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Repository.CustomerRepository;
import com.nmr.demo.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class CustomerController {

    CustomerService cs = new CustomerService();


    public void createCustomer(){

    }

    public void readOneCustomer(){

    }

    @GetMapping("/test")
    public String readCustomers(Model model) {
        System.out.println("controllerlayer");
        model.addAttribute("customers",cs.readAllCustomers());
        return "test";

    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Customer customer = cs.readOneCustomer(id);
        model.addAttribute("customer", customer);
        return "redigerkunde";
    }

    @PostMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") int id, @ModelAttribute Customer customer, Model model){
        customer.setCustomer_id(id);
        cs.updateCustomer(customer);
        model.addAttribute("customer" , cs.readAllCustomers());
        return "redirect:/test";
    }

    @GetMapping("/forside")
    public String forside () {
        return "forside";
    }


    public void deleteCustomer(){

    }
}
