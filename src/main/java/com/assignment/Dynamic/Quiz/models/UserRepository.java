package com.assignment.Dynamic.Quiz.models;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByUsername(String username);
    User findByEmail(String email);
    List<User> findByUsernameAndPassword(String username, String password);
}
