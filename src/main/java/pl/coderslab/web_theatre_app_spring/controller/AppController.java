package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class AppController {

    @GetMapping("/home")
    public String home() { return "home"; }

    @GetMapping("/admins")
    public String showAdminPage(){
        return "admin-page";
    }

    @GetMapping("/managers")
    public String showManagerPage(){
        return "manager-page";
    }

    @GetMapping("/customers")
    public String showCustomerPage(){
        return "customer-page";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() { return "Here you can find some details for logged users" + " Time on a server is " + LocalDateTime.now(); }


}
