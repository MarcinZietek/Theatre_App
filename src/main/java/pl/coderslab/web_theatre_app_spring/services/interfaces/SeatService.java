package pl.coderslab.web_theatre_app_spring.services.interfaces;

import pl.coderslab.web_theatre_app_spring.entities.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> findAll();
}
