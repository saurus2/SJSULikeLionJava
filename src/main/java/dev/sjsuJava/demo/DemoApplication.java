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
	@RequestMapping("/login")
	String login(){
		return "login";
	}
	@RequestMapping("/signup")
	String signup(){
		return "signup";
	}

	static {
        System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
