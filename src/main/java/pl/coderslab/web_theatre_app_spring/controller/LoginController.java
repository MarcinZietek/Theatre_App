package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() { return "/start-page"; }

    @GetMapping("/403")
    public String display403Error() {
        return "/403";
    }

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "login";
    }

}
