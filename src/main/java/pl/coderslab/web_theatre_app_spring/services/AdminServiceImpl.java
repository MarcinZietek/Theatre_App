package pl.coderslab.web_theatre_app_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.web_theatre_app_spring.entities.Role;
import pl.coderslab.web_theatre_app_spring.entities.User;
import pl.coderslab.web_theatre_app_spring.repository.AdminRepository;
import pl.coderslab.web_theatre_app_spring.repository.RoleRepository;
import pl.coderslab.web_theatre_app_spring.services.interfaces.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return adminRepository.getById(id);
    }

    @Override
    public void update(User user) {
        adminRepository.save(user);
    }

    @Override
    public void save(User user) {
        adminRepository.save(user);
    }
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }


}
