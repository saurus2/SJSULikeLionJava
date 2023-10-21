package dev.sjsuJava.demo.Service;

import dev.sjsuJava.demo.Entity.Post;
import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Dto.RoarDto;
import dev.sjsuJava.demo.Entity.Roar;
import dev.sjsuJava.demo.Repository.PostRepository;
import dev.sjsuJava.demo.Repository.RoarRepository;
import dev.sjsuJava.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 자동 주입
public class RoarServiceImpl implements RoarService {
    final UserRepository userRepository;
    final PostRepository postRepository;
    final RoarRepository roarRepository;

    @Override
    public PostDto createRoar(RoarDto dto) {

        // Read and bring information for Roar entity which will be a target to compare
        Roar targetRoar = roarRepository.findByCommenterAndPost(
                userRepository.getReferenceById(dto.getCommenter_id()),
                postRepository.getReferenceById(dto.getPost_id()));

        // If targetRoar is not in roar DB
        if (targetRoar == null) {
            // Create new roar object
            Roar newRoar = Roar.builder()
                    .roar_id(dto.getRoar_id())
                    .commenter(userRepository.getReferenceById(dto.getCommenter_id()))
                    .post(postRepository.getReferenceById(dto.getPost_id()))
                    .build();

            // 1. Save the new Roar entity to the database
            roarRepository.save(newRoar);
            // 2. Find Post with Post_id and update Roars_count to Roars_count + 1
            Post post = postRepository.getReferenceById(dto.getPost_id());
            post.setRoars_count(post.getRoars_count() + 1);
            // 3. Update the Post entity
            return PostDto.from(postRepository.save(post));

        } else { // If targetRoar is in roar DB
            // 1. Delete existing Roar entity (targetRoar) from the database
            roarRepository.deleteById(targetRoar.getRoar_id());

            // 2. Find the Post with Post_id and update Roars_count to Roars_count - 1
            Post post = postRepository.getReferenceById(dto.getPost_id());
            post.setRoars_count(post.getRoars_count() - 1);
            // 3. Update the Post entity
            return PostDto.from(postRepository.save(post));
        }
    }
}
