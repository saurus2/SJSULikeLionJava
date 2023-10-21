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
import dev.sjsuJava.demo.Dto.CommentDto;
import dev.sjsuJava.demo.Service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequiredArgsConstructor // 자동주입
@RequestMapping("/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    private final CommentServiceImpl service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommentDto> upload(@Valid @RequestBody CommentDto dto) {
        logger.info(dto.toString());
        return ResponseEntity.ok(service.upload(dto));
    }

    @GetMapping("")
    public ResponseEntity<List<CommentDto>> readCommentByPostId(@RequestParam(name="post_id", required=true) int id) {
        return ResponseEntity.ok(service.readCommentByPostId(id));
    }

    // @PutMapping("{id}")
    // @ResponseStatus(HttpStatus.OK)
    // public void updateComment(@PathVariable int id, @RequestBody CommentDto dto){
    //     service.update(id, dto);
    // }

    // @DeleteMapping("{id}")
    // @ResponseStatus(HttpStatus.OK)
    // public void deleteComment(@PathVariable int id){
    //     service.delete(id);
    // }
}