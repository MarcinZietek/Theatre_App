package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_theatre_app_spring.entities.Room;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.repository.RoomRepository;
import pl.coderslab.web_theatre_app_spring.repository.SeatRepository;
import pl.coderslab.web_theatre_app_spring.services.RoomServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/managers/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
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

    @GetMapping("/delete/{id}")
    private String deleteRoom(@PathVariable long id){
        roomRepository.deleteById(id);
        return "redirect:/managers/rooms/all";
    }
}
