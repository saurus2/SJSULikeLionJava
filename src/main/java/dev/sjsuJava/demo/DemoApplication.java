package dev.sjsuJava.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {
	// @RequestMapping("/")
	// String home(){
	// 	return "home";
	// }
	@RequestMapping("/login")
	String login(){
		return "login";
	}
	@RequestMapping("/signup")
	String signup(){
		return "signup";
	}
	@RequestMapping("/upload")
	String upload(){
		return "upload";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
