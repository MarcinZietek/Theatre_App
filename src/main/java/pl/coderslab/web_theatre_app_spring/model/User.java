package pl.coderslab.web_theatre_app_spring.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.web_theatre_app_spring.entities.Role;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class User {
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @Length(min = 5, message = "*Proszę podać minimum 5 znaków")
    @NotEmpty(message = "*Proszę podać user name")
    private String username;
    @Length(min = 5, message = "*Hasło musi mieć co najmniej 5 znaków")
    @NotEmpty(message = "*Proszę podać hasło")
    private String password;
    @Email(message = "*Proszę podać poprawny email")
    @NotEmpty(message = "*Proszę podać email")
    private String email;
    @NotEmpty(message = "*Proszę podać imię")
    private String firstName;
    @NotEmpty(message = "*Proszę podać nazwisko")
    private String lastName;
    private boolean enabled;
    private Set<Role> roles;
}
