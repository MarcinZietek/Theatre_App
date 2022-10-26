package pl.coderslab.web_theatre_app_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Seat;
import pl.coderslab.web_theatre_app_spring.repository.SeatRepository;
import pl.coderslab.web_theatre_app_spring.services.interfaces.SeatService;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    @Override
    public void saveSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public Seat findById(Long id) {
        return seatRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        seatRepository.deleteById(id);
    }

    @Override
    public void update(Seat seat) {
        seatRepository.save(seat);
    }
}
