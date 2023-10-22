package dev.sjsuJava.demo.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Entity.Picture;
import dev.sjsuJava.demo.Entity.Post;
import dev.sjsuJava.demo.Entity.User;
import dev.sjsuJava.demo.Repository.PictureRepository;
import dev.sjsuJava.demo.Repository.PostRepository;
import dev.sjsuJava.demo.Repository.UserRepository;
import dev.sjsuJava.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    @Override
    public PostDto upload(PostDto dto) {

        Optional<User> writer = userRepository.findById(dto.getWriter_id());

        if (writer.isEmpty()) {
            throw new NotFoundException("Invalid Writer");
        }

        Optional<Picture> picture = pictureRepository.findById(dto.getPicture_id());

        if (writer.isEmpty()) {
            throw new NotFoundException("Invalid Picture");
        }

        Post post = Post.builder()
                .post_id(dto.getPost_id())
                .writer(writer.get())
                .content(dto.getContent())
                .picture(picture.get())
                .roars_count(dto.getRoars_count())
                .build();

        return PostDto.from(repository.save(post));
    }

    @Override
    public List<PostDto> readAllPost() {
        List<PostDto> postDtolist = new ArrayList<>();
        List<Post> postList = repository.findAll();

        for (Post post : postList) {
            postDtolist.add(PostDto.from(post));
        }
        return postDtolist;
    }

    @Override
    public PostDto readPost(int id) {
        Optional<Post> post = repository.findById((long) id);
        if (post.isEmpty()) {
            throw new NotFoundException();
        }

        return PostDto.from(post.get());
    }

    @Override
    public List<PostDto> readPostByWriterId(int id) {
        Optional<User> writer = userRepository.findById((long) id);
        if (writer.isEmpty()) {
            throw new NotFoundException();
        }

        List<PostDto> postDtolist = new ArrayList<>();
        List<Post> postList = repository.findAllByWriter(writer.get());

        for (Post post : postList) {
            postDtolist.add(PostDto.from(post));
        }
        return postDtolist;
    }

    @Override
    public void update(int id, PostDto dto) {
        Optional<Post> OtargetPost = repository.findById((long) id);
        if (OtargetPost.isEmpty()) {
            throw new NotFoundException();
        }

        Post targetPost = OtargetPost.get();

        Post post = Post.builder()
                .post_id(dto.getPost_id() == null ? targetPost.getPost_id() : dto.getPost_id())
                .writer(dto.getWriter_id() == null ? targetPost.getWriter()
                        : userRepository.getReferenceById(dto.getWriter_id()))
                .content(dto.getContent() == null ? targetPost.getContent() : dto.getContent())
                .picture(dto.getPicture_id() == null ? targetPost.getPicture()
                        : pictureRepository.getReferenceById(dto.getPicture_id()))
                .roars_count(dto.getRoars_count() == null ? targetPost.getRoars_count() : dto.getRoars_count())
                .build();

        repository.save(post);
    }

    @Override
    public void delete(int id) {
        Optional<Post> post = repository.findById((long) id);
        if (post.isEmpty()) {
            throw new NotFoundException("No post found");
        }

        // Delete picture
        Picture pic = post.get().getPicture();
        File file = new File("src/main/resources/static/pictures/" + pic.getStoredFileName() + pic.getExtension());
        file.delete();

        repository.delete(post.get());
    }
}
