package pl.coderslab.web_theatre_app_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.web_theatre_app_spring.entities.User;

public interface CustomerRepository extends JpaRepository<User, Long> {
}

