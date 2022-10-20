package pl.coderslab.web_theatre_app_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_theatre_app_spring.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

}
