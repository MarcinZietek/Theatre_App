package pl.coderslab.web_theatre_app_spring.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.coderslab.web_theatre_app_spring.repository.FilmRepository;
import pl.coderslab.web_theatre_app_spring.services.FilmServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FilmTest {

    @Autowired
    FilmServiceImpl filmService;
    @Autowired
    private FilmRepository filmRepository;

    @Test
    void testFindAllFilms(){
        Film film = new Film();
        filmService.findAll();
        assertThat(film).isNotNull();
    }

    @Test
    void testFindFilmById(){
        long id = 1;
        Optional<Film> film = filmRepository.findById(id);
        assertThat(film).isNotNull();
    }

    @Test
    void testUpdateFilm(){
        long id = 2;
        Optional<Film> film = filmRepository.findById(id);
        Film updatedFilm = new Film();
        updatedFilm.setId(id);
        updatedFilm.setName("Edytowany Film");
        updatedFilm.setDescription("Film został poddany edycji");
        filmRepository.save(updatedFilm);

        assertThat(updatedFilm).isNotNull();
        assertThat(updatedFilm.getId()).isEqualTo(id);
        assertThat(updatedFilm.getName()).isNotEqualTo(film);
    }

    @Test
    void testDeleteFilmById(){
        Film film = new Film();
        film.setName("Nowy Film");
        film.setDescription("Nowo dodany film");
        film.setLengthMin(120);
        Film saved = filmRepository.save(film);
        filmRepository.deleteById(film.getId());
        Optional<Film> deleted = filmRepository.findById(saved.getId());
        assertThat(deleted).isEmpty();
    }

}