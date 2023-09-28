package dev.sjsuJava.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.sjsuJava.demo.Entity.Post;
import dev.sjsuJava.demo.Repository.PostRepository;

@SpringBootTest
public class PostRepositoryTest {
    
    
    @Autowired
    PostRepository postRepository;

    // Insert Test
    @Test
    public void testInsertDummies(){
    // 100개의 새로운 user객체를 생성하고 
        Post post =  Post.builder().title("title").description("desc").writer("writer").build();
        // 저장한다
        postRepository.save(post);        
    }
}
