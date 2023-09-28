package dev.sjsuJava.demo.Service;

import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Entity.User;
import dev.sjsuJava.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 자동 주입
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    @Override
    public Long register(UserDto dto) {
        // service interface에 구현된 dtoToEntity 활용
        User entity = dtoToEntity(dto);

        repository.save(entity);

        return entity.getUser_id();
    }
}
