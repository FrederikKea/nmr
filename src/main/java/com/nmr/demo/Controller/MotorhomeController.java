package com.nmr.demo.Controller;

import com.nmr.demo.Service.MotorhomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorhomeController {

    MotorhomeService ms = new MotorhomeService();


    @GetMapping("oversigtmotorhome")
    public String showAllMotorhomes(Model model) {
        model.addAttribute("motorhomes",ms.readAllMotorhomes());
        return "oversigtmotorhome";
    }


}


