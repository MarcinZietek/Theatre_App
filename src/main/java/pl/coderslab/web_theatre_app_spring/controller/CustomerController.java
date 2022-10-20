package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.web_theatre_app_spring.entities.Film;
import pl.coderslab.web_theatre_app_spring.entities.Room;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.services.FilmServiceImpl;
import pl.coderslab.web_theatre_app_spring.services.RoomServiceImpl;
import pl.coderslab.web_theatre_app_spring.services.SeatServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/customers/films")
public class CustomerController {

    private final RoomServiceImpl roomServiceImpl;
    private final FilmServiceImpl filmServiceImpl;

    public CustomerController(RoomServiceImpl roomServiceImpl, FilmServiceImpl filmServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
        this.filmServiceImpl = filmServiceImpl;
    }

    @GetMapping("/all")
    public String showFilms(Model model){
        List<Film> films = filmServiceImpl.findAll();
        List<Room> roomList = filmServiceImpl.getRooms();
        model.addAttribute("films", films);
        model.addAttribute("roomList", roomList);
        return "customer-film-list";
    }

    @GetMapping("/show/{id}")
    public String showFilm(Model model, @PathVariable long id) {
        List<Room> roomList = filmServiceImpl.getRooms();
        model.addAttribute("films", filmServiceImpl.findById(id));
        model.addAttribute("roomList", roomList);
        return "customer-film-show";
    }

//    @GetMapping("/seats/all")
//    public String showSeats(Model model){
//        List<Seat> seatList = roomServiceImpl.getSeats();
//        model.addAttribute("seatList", seatList);
//        return "booking-room";
//    }

}
