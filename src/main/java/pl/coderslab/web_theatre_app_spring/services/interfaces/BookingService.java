package pl.coderslab.web_theatre_app_spring.services.interfaces;

import pl.coderslab.web_theatre_app_spring.entities.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> findAll();
    void saveBooking(Booking booking);
    void deleteById(Long id);
}
