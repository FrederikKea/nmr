package com.nmr.demo.Controller;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Repository.CustomerRepository;
import com.nmr.demo.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/forside")
    public String forside () {
        return "forside";
    }

    public void udpateCustomer(){

    }

    public void deleteCustomer(){

    }
}
