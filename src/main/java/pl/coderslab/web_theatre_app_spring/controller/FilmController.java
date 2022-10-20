package pl.coderslab.web_theatre_app_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_theatre_app_spring.entities.Film;
import pl.coderslab.web_theatre_app_spring.entities.Room;
import pl.coderslab.web_theatre_app_spring.entities.Screening;
import pl.coderslab.web_theatre_app_spring.services.RoomServiceImpl;
import pl.coderslab.web_theatre_app_spring.services.ScreeningServiceImpl;
import pl.coderslab.web_theatre_app_spring.services.interfaces.FilmService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/managers/films")
public class FilmController {

    private final FilmService filmService;
    private final RoomServiceImpl roomServiceImpl;
    private final ScreeningServiceImpl screeningServiceImpl;

    @Autowired
    public FilmController(FilmService filmService, RoomServiceImpl roomServiceImpl, ScreeningServiceImpl screeningServiceImpl) {
        this.filmService = filmService;
        this.roomServiceImpl = roomServiceImpl;
        this.screeningServiceImpl = screeningServiceImpl;
    }

    @GetMapping("/all")
    public String showFilms(Model model){
        List<Film> films = filmService.findAll();
        model.addAttribute("films", films);
        return "film-list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("filmId") long id, Model model){
        List<Room> roomList = roomServiceImpl.getRooms();
        List<Screening> screeningList = screeningServiceImpl.findAll();
        model.addAttribute("film", filmService.findById(id));
        model.addAttribute("roomList", roomList);
        model.addAttribute("screeningsList", screeningList);
        return "film-edit";
    }

    @PostMapping("/edit")
    public String editFilm(Film film, Room room){
        filmService.saveFilm(film);
        return "redirect:/managers/films/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model){
        model.addAttribute("film", new Film());
        return "film-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveFilm(@Valid Film film){
        filmService.saveFilm(film);
        return "redirect:/managers/films/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable long id) {
        filmService.deleteById(id);
        return "redirect:/managers/films/all";
    }

    @GetMapping("/show/{id}")
    public String showFilm(Model model, @PathVariable long id) {
        model.addAttribute("films", filmService.findById(id));
        return "film-show";
    }
}
