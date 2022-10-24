package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_theatre_app_spring.entities.Room;
import pl.coderslab.web_theatre_app_spring.entities.Screening;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.repository.RoomRepository;
import pl.coderslab.web_theatre_app_spring.repository.SeatRepository;
import pl.coderslab.web_theatre_app_spring.services.RoomServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/managers/rooms")
public class RoomController {

    private final RoomRepository roomRepository;
    private final RoomServiceImpl roomServiceImpl;

    public RoomController(RoomRepository roomRepository, RoomServiceImpl roomServiceImpl) {
        this.roomRepository = roomRepository;
        this.roomServiceImpl = roomServiceImpl;
    }

    @GetMapping("/all")
    private String showRooms(Model model){
        List<Room> roomList = roomRepository.findAll();
        model.addAttribute("rooms", roomList);
        return "room-list";
    }

    @GetMapping("/edit")
    private String showEditForm(@RequestParam("roomId") long id, Model model){
        model.addAttribute("rooms", roomRepository.findById(id));
        return "room-edit";
    }

    @PostMapping("/edit")
    private String editRoom(Room room){
        roomRepository.save(room);
        return "redirect:/managers/rooms/all";
    }

    @GetMapping("/add")
    private String showEditForm(Model model){
        model.addAttribute("room", new Room());
        return "room-add";
    }

    @PostMapping("/add")
    private String saveScreening(@Valid Room room){
        roomServiceImpl.saveRoom(room);
        return "redirect:/managers/rooms/all";
    }

    @GetMapping("/delete/{id}")
    private String deleteRoom(@PathVariable long id){
        roomRepository.deleteById(id);
        return "redirect:/managers/rooms/all";
    }
}
