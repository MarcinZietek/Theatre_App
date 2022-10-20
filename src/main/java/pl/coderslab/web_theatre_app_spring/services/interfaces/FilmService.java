package pl.coderslab.web_theatre_app_spring.services.interfaces;

import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Film;

import java.util.List;

@Service
public interface FilmService {

    List<Film> findAll();
    void saveFilm(Film film);
    Film findById(Long id);
    void deleteById(Long id);
    void update(Film film);
}
