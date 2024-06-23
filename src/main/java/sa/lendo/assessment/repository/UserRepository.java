package sa.lendo.assessment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sa.lendo.assessment.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(Long userId);
    List<User> findAll();
    void deleteUserByUserId(Long userId);
}
