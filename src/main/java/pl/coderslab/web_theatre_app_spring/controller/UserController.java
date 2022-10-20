package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.web_theatre_app_spring.entities.User;
import pl.coderslab.web_theatre_app_spring.services.interfaces.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("admin@admin.pl");
        user.setFirstName("Marcin");
        user.setLastName("Ziętek");
        user.setEnabled(true);
        user.isEnabled();
        userService.saveUser(user);
        return "You have created " + user.getUsername() + " " + user.getRoles();
    }
}
