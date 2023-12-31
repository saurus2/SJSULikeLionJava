package dev.sjsuJava.demo.Service;

import java.util.List;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Entity.User;

public interface UserService {

    UserDto signup(UserDto dto);
    UserDto login(UserDto dto);
    List<UserDto> readAllUsers();
    UserDto readUser(int id);
    void update(int id, UserDto dto);
    void delete(int id);

    // service 에서는 파라미터를 DTO타입으로 받기 때문에 JPA로 처리하기 위해서는 Entity 타입의 객체로 변환해야 하는 작업이 반드시 필요하다
    default User dtoToEntity(UserDto dto){
        User entity = User.builder()
                .user_id(dto.getUser_id())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .name(dto.getName())
                .build();
        return entity;
    }
}