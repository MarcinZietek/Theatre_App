package pl.coderslab.web_theatre_app_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_theatre_app_spring.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAllByRolesId(long idRole);
    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    User findByVerificationCode(String code);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findUserByEmail(String email);
    User findByResetPasswordToken(String token);
}
