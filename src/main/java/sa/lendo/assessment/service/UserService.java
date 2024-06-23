package sa.lendo.assessment.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import sa.lendo.assessment.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username);
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);
    User saveUser(User user);
}
