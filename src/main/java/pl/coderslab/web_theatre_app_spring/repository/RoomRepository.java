package pl.coderslab.web_theatre_app_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_theatre_app_spring.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
