package dev.sjsuJava.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Dto.RoarDto;
import dev.sjsuJava.demo.Service.RoarServiceImpl;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // 자동주입
@RequestMapping("/roar")
public class RoarController {

    private final RoarServiceImpl service;

    @PostMapping("")
    public ResponseEntity<PostDto> createRoar(@RequestBody RoarDto dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createRoar(dto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}