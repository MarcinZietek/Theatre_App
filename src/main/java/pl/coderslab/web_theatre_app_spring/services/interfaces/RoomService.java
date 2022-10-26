package pl.coderslab.web_theatre_app_spring.services.interfaces;

import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Room;

import java.util.List;

@Service
public interface RoomService {

    List<Room> findAll();
    void saveRoom(Room room);
    Room findById(Long id);
}
