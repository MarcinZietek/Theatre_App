package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.services.SeatServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/managers/seats")
public class SeatController {

        private final SeatServiceImpl seatServiceImpl;

    public SeatController(SeatServiceImpl seatServiceImpl) {
        this.seatServiceImpl = seatServiceImpl;
    }

    @GetMapping("/all")
    private String showRooms(Model model){
        List<Seat> seats = seatServiceImpl.findAll();
        model.addAttribute("seats", seats);
        return "seat-list";
    }

    @GetMapping("/edit")
    private String showEditForm(@RequestParam("seatId") long id, Model model){
        model.addAttribute("seats", seatServiceImpl.findById(id));
        return "seat-edit";
    }

    @PostMapping("/edit")
    private String editRoom(Seat seat){
        seatServiceImpl.update(seat);
        return "redirect:/managers/seats/all";
    }

    @GetMapping("/add")
    private String showEditForm(Model model){
        model.addAttribute("seats", new Seat());
        return "seat-add";
    }

    @PostMapping("/add")
    private String saveScreening(@Valid Seat seat){
        seatServiceImpl.saveSeat(seat);
        return "redirect:/managers/seats/all";
    }

    @GetMapping("/delete/{id}")
    private String deleteRoom(@PathVariable long id){
        seatServiceImpl.deleteById(id);
        return "redirect:/managers/seats/all";
    }
}
