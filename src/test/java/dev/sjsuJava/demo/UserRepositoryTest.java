package dev.sjsuJava.demo;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.sjsuJava.demo.Entity.User;

@SpringBootTest
public class UserRepositoryTest {
    
    
    @Autowired
    UserRepository userRepository;

    // Insert Test
    @Test
    public void testInsertDummies(){
    // 100개의 새로운 user객체를 생성하고 
        IntStream.rangeClosed(1,10).forEach(i -> {
           User user =  User.builder().firstname("JY" + i).lastname("Yoon").role("admin").username("guest"+i).password("1234").build();
            // 저장한다
           userRepository.save(user);
        });
    }


    // Select Test
    @Test
    public void testSelect(){
        Long id = 5L;
        Optional<User> result = userRepository.findById(id);
        System.out.println("================");
        if(result.isPresent()){
            User user = result.get();
            System.out.println(user.getUsername());
        }
    }

    // Update
    @Test
    public void testUpdate(){
        // 객체 생성
        Long id = 12L;
        User user = userRepository.getById(id);
        user.setPassword("asdasd");
        System.out.println("1-------------");
        userRepository.save(user);
        System.out.println("2-------------");
    }

    // Delete
    @Test
    public void testDelete(){
        Long id = 7L;
        userRepository.deleteById(id);
    }
}
