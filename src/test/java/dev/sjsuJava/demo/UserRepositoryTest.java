package dev.sjsuJava.demo;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.sjsuJava.demo.Entity.User;
import dev.sjsuJava.demo.Repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

    // @Autowired
    // UserRepository userRepository;

    // // Select Test
    // @Test
    // public void testSelect() {
    // Long id = 5L;
    // Optional<User> result = userRepository.findById(id);
    // System.out.println("================");
    // if (result.isPresent()) {
    // User user = result.get();
    // System.out.println(user.getUsername());
    // }
    // }
}