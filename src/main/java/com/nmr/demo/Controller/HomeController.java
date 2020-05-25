package com.nmr.demo.Controller;

import com.nmr.demo.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    CustomerService cs = new CustomerService();

    @GetMapping("/")
    public String forside () {
        return "forside";
    }

    @GetMapping("/index")
    public String index() { return "forside"; }
}
//Fra Son
//Fra Frederik
//Fra Jakob