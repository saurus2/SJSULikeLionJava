package dev.sjsuJava.demo.Service;

import dev.sjsuJava.demo.Dto.CommentDto;
import dev.sjsuJava.demo.Entity.Comment;

public interface CommentService {

    Long register(CommentDto dto);

    // service 에서는 파라미터를 DTO타입으로 받기 때문에 JPA로 처리하기 위해서는 Entity 타입의 객체로 변환해야 하는 작업이 반드시 필요하다
    default Comment dtoToEntity(CommentDto dto){
        Comment entity = Comment.builder()
                .comment_id(dto.getComment_id())
                .post_id(dto.getPost_id())
                .commenter(dto.getCommenter())
                .content(dto.getContent())
                .build();
        return entity;
    }
}