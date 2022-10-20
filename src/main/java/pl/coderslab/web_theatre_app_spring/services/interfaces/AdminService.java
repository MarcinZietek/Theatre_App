package pl.coderslab.web_theatre_app_spring.services.interfaces;

import pl.coderslab.web_theatre_app_spring.entities.User;

import java.util.List;

public interface AdminService {

    List<User> findAll();
    void deleteById(Long id);
    User findById(Long id);
    void update(User user);
    void save(User user);
}
