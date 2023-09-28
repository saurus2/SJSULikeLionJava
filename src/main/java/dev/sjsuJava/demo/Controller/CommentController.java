package dev.sjsuJava.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.sjsuJava.demo.Service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor // 자동주입
@RequestMapping("/comment")
public class CommentController {

    private final CommentServiceImpl service;

    @GetMapping("/")
    public String index(){
        return "redirect:/comment/list";
    }
}