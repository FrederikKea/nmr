package com.nmr.demo.Service;

import com.nmr.demo.Model.Customer;
import com.nmr.demo.Repository.CustomerRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    CustomerRepository cr = new CustomerRepository();

    public void createCustomer(Customer customer){
        cr.createCustomer(customer);
    }

    public Customer readOneCustomer(int id){
        Customer customer = new Customer();
        customer = cr.readOneCustomer(id);
        return customer;
    }

    public List<Customer> readAllCustomers() {
        List <Customer> allCustomers = new ArrayList<>();
        allCustomers = cr.readAllCustomers();
        return allCustomers;
    }

    public void updateCustomer(Customer c){
        cr.updateCustomer(c);
    }

    public String validateandupdateCustomer(Customer customer, BindingResult binding, Model model){
        if (binding.hasErrors()){
            return "redigerkunde";
        }
        cr.updateCustomer(customer);
        model.addAttribute("customer" , this.readAllCustomers());
        return ("redirect:/test");
    }

    public void deleteCustomer(int customerId){
        cr.deleteCustomer(customerId);
    }
}
