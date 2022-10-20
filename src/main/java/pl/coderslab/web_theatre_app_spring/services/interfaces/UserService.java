package pl.coderslab.web_theatre_app_spring.services.interfaces;


import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
    void save(User user);
    void registerUser(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;
    void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;
    void saveUserExceptPassword(User user);
    void savePassword(User user);
    User findById(Long id);
}
