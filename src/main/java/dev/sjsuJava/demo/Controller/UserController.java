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
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    /* Get all users info */
    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers(HttpServletRequest request){
        return ResponseEntity.ok(service.getUsers());
    }

    /** SIGN UP */
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(
            @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.signup(userDto));
    }

    /* LOG IN */
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody UserDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}