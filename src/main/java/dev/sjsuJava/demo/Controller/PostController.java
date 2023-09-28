package dev.sjsuJava.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.sjsuJava.demo.Service.PostServiceImpl;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor // 자동주입
@RequestMapping("/post")
public class PostController {

    private final PostServiceImpl service;

    @GetMapping("/")
    public String index(){
        return "redirect:/post/list";
    }
}