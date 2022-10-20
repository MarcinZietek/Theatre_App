package pl.coderslab.web_theatre_app_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @Length(min = 5, message = "*Proszę podać minimum 5 znaków")
    @NotEmpty(message = "*Proszę podać user name")
    private String username;
    @Length(min = 5, message = "*Hasło musi mieć co najmniej 5 znaków")
    @NotEmpty(message = "*Proszę podać hasło")
    private String password;
    @Transient
    private String confirmPassword;
    @Email(message = "*Proszę podać poprawny email")
    @NotEmpty(message = "*Proszę podać email")
    private String email;
    @NotEmpty(message = "*Proszę podać imię")
    private String firstName;
    @NotEmpty(message = "*Proszę podać nazwisko")
    private String lastName;
    @Column(length = 64)
    private String verificationCode;
    private String resetPasswordToken;
    private boolean enabled;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
