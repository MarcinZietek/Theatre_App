package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.web_theatre_app_spring.entities.User;

import pl.coderslab.web_theatre_app_spring.services.interfaces.UserService;


import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "/registration";

    }

    @PostMapping("/register")
    public String saveUser(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/registration";
        }

        userService.saveUser(user);
        return "redirect:/";
    }


}
