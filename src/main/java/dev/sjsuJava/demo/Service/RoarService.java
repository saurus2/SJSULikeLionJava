package dev.sjsuJava.demo.Service;

import dev.sjsuJava.demo.Dto.RoarDto;
import dev.sjsuJava.demo.Entity.Roar;

public interface RoarService {

    Long register(RoarDto dto);

    // service 에서는 파라미터를 DTO타입으로 받기 때문에 JPA로 처리하기 위해서는 Entity 타입의 객체로 변환해야 하는 작업이 반드시 필요하다
    default Roar dtoToEntity(RoarDto dto){
        Roar entity = Roar.builder()
                .roar_id(dto.getRoar_id())
                .user_id(dto.getUser_id())
                .post_id(dto.getPost_id())
                .build();
        return entity;
    }
}