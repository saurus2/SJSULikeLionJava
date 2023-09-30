package dev.sjsuJava.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class indexToLogin {
    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("data", "login");
        return "/login";
    }
}
