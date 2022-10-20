package pl.coderslab.web_theatre_app_spring.services.interfaces;

import pl.coderslab.web_theatre_app_spring.entities.Screening;

import java.util.List;

public interface ScreeningService {
    List<Screening> findAll();
}