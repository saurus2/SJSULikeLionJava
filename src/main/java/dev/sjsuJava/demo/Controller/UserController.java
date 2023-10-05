package dev.sjsuJava.demo.Controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Service.UserService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.signup(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody UserDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> readAllUsers(){
        return ResponseEntity.ok(service.readAllUsers());
    }


    @GetMapping("{id}")
    public ResponseEntity<UserDto> readUser(@PathVariable(name="id") int id){
        return ResponseEntity.ok(service.readUser(id));
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name="id") int id, @RequestBody UserDto dto){
        service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name="id") int id){
        service.delete(id);
    }    
}