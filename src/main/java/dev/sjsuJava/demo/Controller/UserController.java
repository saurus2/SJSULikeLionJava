package dev.sjsuJava.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Service.UserService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor // 자동주입
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers(HttpServletRequest request){
        return ResponseEntity.ok(service.getUsers());
    }

    /** 유저 정보 등록하기 */
    @PostMapping("signup")
    public ResponseEntity<UserDto> insertUser(
            @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.signup(userDto));
    }
}