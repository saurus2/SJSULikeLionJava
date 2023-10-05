package dev.sjsuJava.demo.Service;

import java.util.List;

import dev.sjsuJava.demo.Dto.PostDto;

public interface PostService {

    PostDto upload(PostDto dto);
    List<PostDto> readAllPost();
    PostDto readPost(int id);
    List<PostDto> readPostByWriterId(int id);
    void update(int id, PostDto dto);
    void delete(int id);
}