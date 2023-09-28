package dev.sjsuJava.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Entity.User;
import dev.sjsuJava.demo.Repository.UserRepository;
import dev.sjsuJava.demo.exception.DuplicateMemberException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    /* SIGN UP */
    @Override
    public UserDto signup(UserDto dto) {
        if (repository.findByUsername(dto.getUsername()) != null) {
            throw new DuplicateMemberException("This username is taken. Try another.");
        }

        User entity = dtoToEntity(dto);
        return UserDto.from(repository.save(entity));
    }

    @Override
    public List<UserDto> getUsers() {
        return repository.findAll().stream()
            .map(user -> UserDto.from(user))
            .collect(Collectors.toList());
    }
}
