package pl.coderslab.web_theatre_app_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Room;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.repository.RoomRepository;
import pl.coderslab.web_theatre_app_spring.repository.SeatRepository;
import pl.coderslab.web_theatre_app_spring.services.interfaces.RoomService;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, SeatRepository seatRepository) {
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.getById(id);
    }

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public List<Seat> getSeats(){ return seatRepository.findAll();}
}
