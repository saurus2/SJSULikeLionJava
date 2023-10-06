package dev.sjsuJava.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequiredArgsConstructor // 자동주입
@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostServiceImpl service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostDto> upload(@Valid @RequestBody PostDto dto) {
        logger.info(dto.toString());
        return ResponseEntity.ok(service.upload(dto));
    }

    @GetMapping("")
    public ResponseEntity<List<PostDto>> readAllPost(){
        return ResponseEntity.ok(service.readAllPost());
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> readPost(@PathVariable(name="id") int id) {
        return ResponseEntity.ok(service.readPost(id));
    }

    @GetMapping("writer")
    public ResponseEntity<List<PostDto>> readPostByWriterId(@RequestParam(name="id", required=true) int id) {
        return ResponseEntity.ok(service.readPostByWriterId(id));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable int id, @RequestBody PostDto dto){
        service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable int id){
        service.delete(id);
    }
}