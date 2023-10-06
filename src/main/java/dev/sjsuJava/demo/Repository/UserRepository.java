package dev.sjsuJava.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sjsuJava.demo.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
