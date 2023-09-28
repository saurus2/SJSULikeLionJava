package dev.sjsuJava.demo.Service;

import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Entity.Post;

public interface PostService {

    Long register(PostDto dto);

    // service 에서는 파라미터를 DTO타입으로 받기 때문에 JPA로 처리하기 위해서는 Entity 타입의 객체로 변환해야 하는 작업이 반드시 필요하다
    default Post dtoToEntity(PostDto dto){
        Post entity = Post.builder()
                .post_id(dto.getPost_id())
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .pic_id(dto.getPic_id())
                .roars_count(dto.getRoars_count())
                .build();
        return entity;
    }
}