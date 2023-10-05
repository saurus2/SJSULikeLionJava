package dev.sjsuJava.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Entity.Post;
import dev.sjsuJava.demo.Entity.User;
import dev.sjsuJava.demo.Repository.PostRepository;
import dev.sjsuJava.demo.Repository.UserRepository;
import dev.sjsuJava.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final UserRepository userRepository;
    private final PostRepository repository;
    
    @Override
    public PostDto upload(PostDto dto) {

        Optional<User> writer = userRepository.findById(dto.getWriter_id());

        if(writer.isEmpty()) {
            throw new NotFoundException("Invalid Writer");
        }

        Post post = Post.builder()
                .post_id(dto.getPost_id())
                .writer(userRepository.getReferenceById(dto.getWriter_id()))
                .content(dto.getContent())
                .pic_id(dto.getPic_id())
                .roars_count(dto.getRoars_count())
                .build();       

        return PostDto.from(repository.save(post));
    }

    @Override
    public List<PostDto> readAllPost() {
        List<PostDto> postDtolist = new ArrayList<>();
        List<Post> postList = repository.findAll();

        for(Post post : postList) {
            postDtolist.add(PostDto.from(post));
        }
        return postDtolist;
    }

    @Override
    public PostDto readPost(int id) {
        Optional<Post> post = repository.findById((long) id);
        if(post.isEmpty()) {
            throw new NotFoundException();
        }
        
        return PostDto.from(post.get());
    }

    @Override
    public List<PostDto> readPostByWriterId(int id) {
        Optional<User> writer = userRepository.findById((long) id);
        if(writer.isEmpty()) {
            throw new NotFoundException();
        }
        
        List<PostDto> postDtolist = new ArrayList<>();
        List<Post> postList = repository.findAllByWriter(writer.get());

        for(Post post : postList) {
            postDtolist.add(PostDto.from(post));
        }
        return postDtolist;
    }

    @Override
    public void update(int id, PostDto dto) {
        Optional<Post> OtargetPost = repository.findById((long) id);
        if(OtargetPost.isEmpty()) {
            throw new NotFoundException();
        }

        Post targetPost = OtargetPost.get();

        Post post = Post.builder()
            .post_id(dto.getPost_id() == null ? targetPost.getPost_id() : dto.getPost_id())
            .writer(dto.getWriter_id() == null ? targetPost.getWriter() : userRepository.getReferenceById(dto.getWriter_id()))
            .content(dto.getContent() == null ? targetPost.getContent() : dto.getContent())
            .pic_id(dto.getPic_id() == null ? targetPost.getPic_id() : dto.getPic_id())
            .roars_count(dto.getRoars_count() == null ? targetPost.getRoars_count() : dto.getRoars_count())
        .build();
        
        repository.save(post);
    }

    @Override
    public void delete(int id) {
        Optional<Post> post = repository.findById((long) id);
        if(post.isEmpty()) {
            throw new NotFoundException();
        }

        repository.delete(post.get());
    }
}
