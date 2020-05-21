package com.nmr.demo.Controller;

import com.nmr.demo.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class CustomerController {

    CustomerService cs = new CustomerService();


    public void createCustomer(){

    }

    public void readOneCustomer(){

    }

    @GetMapping("/test")
    public String readCustomers(Model model) throws SQLException {
        System.out.println("controllerlayer");
        model.addAttribute("customers",cs.readCustomers());
        return "test";

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
