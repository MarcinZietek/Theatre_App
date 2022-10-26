package pl.coderslab.web_theatre_app_spring.services.interfaces;

import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Film;
import pl.coderslab.web_theatre_app_spring.entities.Seat;

import java.util.List;

@Service
public interface SeatService {
    List<Seat> findAll();
    void saveSeat(Seat seat);
    Seat findById(Long id);
    void deleteById(Long id);
    void update(Seat seat);
}
