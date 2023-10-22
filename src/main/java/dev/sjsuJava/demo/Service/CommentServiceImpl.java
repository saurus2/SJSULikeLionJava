package dev.sjsuJava.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.CommentDto;
import dev.sjsuJava.demo.Entity.Comment;
import dev.sjsuJava.demo.Repository.CommentRepository;
import dev.sjsuJava.demo.Repository.PostRepository;
import dev.sjsuJava.demo.Repository.UserRepository;
import dev.sjsuJava.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public CommentDto upload(CommentDto dto) {
        // db 에 저장
        Comment comment = Comment.builder()
                .comment_id(dto.getComment_id())
                .content(dto.getContent())
                .post(postRepository.getReferenceById(dto.getPost_id()))
                .commenter(userRepository.getReferenceById(dto.getCommenter_id()))
                .build();
        return CommentDto.from(repository.save(comment));
    }

    @Override
    public List<CommentDto> readCommentByPostId(int post_id) {
        List<CommentDto> commentDtolist = new ArrayList<>();
        List<Comment> commentList = repository.findByPost(postRepository.getReferenceById((long) post_id));

        for (Comment comment : commentList) {
            commentDtolist.add(CommentDto.from(comment));
        }

        return commentDtolist;
    }

    @Override
    public void delete(int id) {
        Optional<Comment> comment = repository.findById((long) id);

        if (comment.isEmpty()) {
            throw new NotFoundException();
        }

        repository.delete(comment.get());
    }

}
