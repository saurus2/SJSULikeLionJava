package dev.sjsuJava.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.sjsuJava.demo.Service.RoarServiceImpl;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor // 자동주입
@RequestMapping("/roar")
public class RoarController {

    private final RoarServiceImpl service;

    @GetMapping("/")
    public String index(){
        return "redirect:/roar/list";
    }
}