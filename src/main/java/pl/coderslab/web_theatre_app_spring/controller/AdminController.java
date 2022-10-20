package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_theatre_app_spring.entities.Role;
import pl.coderslab.web_theatre_app_spring.entities.User;
import pl.coderslab.web_theatre_app_spring.model.CurrentUser;
import pl.coderslab.web_theatre_app_spring.services.AdminServiceImpl;
import pl.coderslab.web_theatre_app_spring.services.UserServiceImpl;
import pl.coderslab.web_theatre_app_spring.services.interfaces.AdminService;
import pl.coderslab.web_theatre_app_spring.services.interfaces.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admins/users")
public class AdminController {

    private final AdminService adminService;
    private final AdminServiceImpl adminServiceImpl;
    private final UserService userService;
    private final UserServiceImpl userServiceImpl;

    public AdminController(AdminService adminService, AdminServiceImpl adminServiceImpl, UserService userService, UserServiceImpl userServiceImpl) {
        this.adminService = adminService;
        this.adminServiceImpl = adminServiceImpl;
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/all")
    public String showFilms(Model model){
        List<User> users = adminService.findAll();
        model.addAttribute("users", users);
        return "users-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable long id) {
        adminService.deleteById(id);
        return "redirect:/admins/users/all";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("userId") long id, Model model){
        List<Role> roleList = adminServiceImpl.getRoles();
        model.addAttribute("user", adminService.findById(id));
        model.addAttribute("roleList", roleList);
        return "users-edit";
    }

    @PostMapping("/edit")
    public String editUser( User user){

        adminServiceImpl.save(user);
        return "redirect:/admins/users/all";
    }

    @GetMapping("/editPassword")
    public String editPassword(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = userServiceImpl.findById(currentUser.getUser().getId());
        model.addAttribute("user", user);
        return "user/user-edit-password";
    }

    @PostMapping("/editPassword")
    public String saveEditedPassword(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){ return "user/user-edit-password"; }
        if (!user.getPassword().equals(user.getConfirmPassword())){
            return "user/user-edit-password";
        }
        else {
            userServiceImpl.savePassword(user);
            return "redirect:user";
        }
    }
}
