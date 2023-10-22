package dev.sjsuJava.demo.Service;

import java.util.List;

import dev.sjsuJava.demo.Dto.CommentDto;

public interface CommentService {

    CommentDto upload(CommentDto dto);

    // List<CommentDto> readAllComment();
    // CommentDto readComment(int id);
    List<CommentDto> readCommentByPostId(int post_id);

    // void update(int id, CommentDto dto);
    void delete(int id);
}