package pl.coderslab.web_theatre_app_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Film;
import pl.coderslab.web_theatre_app_spring.entities.Room;
import pl.coderslab.web_theatre_app_spring.entities.Screening;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.repository.FilmRepository;
import pl.coderslab.web_theatre_app_spring.repository.RoomRepository;
import pl.coderslab.web_theatre_app_spring.repository.ScreeningRepository;
import pl.coderslab.web_theatre_app_spring.repository.SeatRepository;
import pl.coderslab.web_theatre_app_spring.services.interfaces.FilmService;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final RoomRepository roomRepository;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, RoomRepository roomRepository, ScreeningRepository screeningRepository, SeatRepository seatRepository) {
        this.filmRepository = filmRepository;
        this.roomRepository = roomRepository;
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public void saveFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public Film findById(Long id) {
        Optional<Film> result = filmRepository.findById(id);
        Film film = null;
        if (result.isPresent()){
            film = result.get();
        }else{
            throw new RuntimeException(("Did not find employee id - " + id));
        }
        return film;
    }

    @Override
    public void deleteById(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public void update(Film film) {
        filmRepository.save(film);
    }

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public List<Screening> getScreenings(){return screeningRepository.findAll();}

    public List<Seat> getSeats(){return seatRepository.findAll();}
}