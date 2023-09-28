package dev.sjsuJava.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor // 자동주입
@RequestMapping("/user")
public class UserController {

    // private final UserService service;

    @GetMapping("/")
    public String index(){
        return "redirect:/user/list";
    }
}