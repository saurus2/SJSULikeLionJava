package dev.sjsuJava.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class indexToSignUp {
    @GetMapping("signup")
    public String signup(Model model){
        model.addAttribute("data", "signup");
        return "/signup";
    }
}
