package dev.sjsuJava.demo.Service;

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

        Roar targetRoar = roarRepository.findByCommenterAndPost(
                userRepository.getReferenceById(dto.getCommenter_id()),
                postRepository.getReferenceById(dto.getPost_id()));

        Roar entity = Roar.builder()
                .roar_id(dto.getRoar_id())
                .commenter(userRepository.getReferenceById(dto.getCommenter_id()))
                .post(postRepository.getReferenceById(dto.getPost_id()))
                .build();

        // DB 에 없을 때
        if (targetRoar == null) {
            // 1. DB에 save
            // 2. Post_id로 Post 찾아서 count 업데이트
        }
        // DB 에 있을 때
        else {
            // 1. db 에서 지우기
            // 2. count -= 1
        }

        return PostDto.from(postRepository.getReferenceById(dto.getPost_id()));
    }
}
