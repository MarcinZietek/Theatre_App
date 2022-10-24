package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.web_theatre_app_spring.entities.Screening;
import pl.coderslab.web_theatre_app_spring.services.ScreeningServiceImpl;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/managers/screenings")
public class ScreeningController {

    private final ScreeningServiceImpl screeningServiceImpl;

    public ScreeningController(ScreeningServiceImpl screeningServiceImpl) {
        this.screeningServiceImpl = screeningServiceImpl;
    }

    @GetMapping("/all")
    private String showScreenings(Model model){
        List<Screening> screeningList = screeningServiceImpl.findAll();
        model.addAttribute("screenings", screeningList);
        return "screening-list";
    }

    @GetMapping("/add")
    private String showEditForm(Model model){
        model.addAttribute("screening", new Screening());
        return "screening-add";
    }

    @PostMapping("/add")
    private String saveScreening(@Valid Screening screening){
        screeningServiceImpl.saveScreening(screening);
        return "redirect:/managers/screenings/all";
    }

    @GetMapping("/delete/{id}")
    private String deleteScreening(@PathVariable long id){
        screeningServiceImpl.deleteById(id);
        return "redirect:/managers/screenings/all";
    }
}
