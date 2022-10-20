package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.services.RoomServiceImpl;
import pl.coderslab.web_theatre_app_spring.services.SeatServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/seats")
public class BookingController {

    private final SeatServiceImpl seatServiceImpl;
    private final RoomServiceImpl roomServiceImpl;

    public BookingController(SeatServiceImpl seatServiceImpl, RoomServiceImpl roomServiceImpl) {
        this.seatServiceImpl = seatServiceImpl;
        this.roomServiceImpl = roomServiceImpl;
    }

    @GetMapping("/all")
    public String showSeats(Model model){
        List<Seat> seatList = roomServiceImpl.getSeats();
        model.addAttribute("seatList", seatList);
        return "booking-room";
    }

}
