package com.nmr.demo.Controller;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CustomerController {

    CustomerService cs = new CustomerService();


    @PostMapping("/addCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        cs.createCustomer(customer);
        return "redirect:/test";
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
    public String updateCustomer(@PathVariable("id") int id, @Valid @ModelAttribute Customer customer, BindingResult binding, Model model){
        customer.setCustomer_id(id);
        String validateandupdate = cs.validateandupdateCustomer(customer, binding, model);
        return validateandupdate;
    }

    @GetMapping("/forside")
    public String forside () {
        return "forside";
    }


    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        System.out.println(id);
        cs.deleteCustomer(id);
        return "redirect:/test";

    }
}
