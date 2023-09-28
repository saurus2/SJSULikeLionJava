package dev.sjsuJava.demo.Service;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Entity.User;

public interface UserService {

    Long register(UserDto dto);

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