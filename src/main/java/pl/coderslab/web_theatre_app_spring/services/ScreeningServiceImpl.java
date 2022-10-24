package pl.coderslab.web_theatre_app_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Screening;
import pl.coderslab.web_theatre_app_spring.repository.ScreeningRepository;
import pl.coderslab.web_theatre_app_spring.services.interfaces.ScreeningService;

import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public List<Screening> findAll() {
        return screeningRepository.findAll();
    }

    @Override
    public void saveScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public void deleteById(Long id) {
        screeningRepository.deleteById(id);
    }
}
