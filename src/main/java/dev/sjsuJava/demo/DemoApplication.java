package dev.sjsuJava.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {
	@RequestMapping("/")
	String home(){
		return "Hello World!";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
