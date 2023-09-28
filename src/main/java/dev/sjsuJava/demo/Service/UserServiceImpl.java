package dev.sjsuJava.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Entity.User;
import dev.sjsuJava.demo.Repository.UserRepository;
import dev.sjsuJava.demo.exception.DuplicateMemberException;
import dev.sjsuJava.demo.exception.NotFoundException;
import dev.sjsuJava.demo.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    /* GET ALL USERS INFO */
    @Override
    public List<UserDto> getUsers() {
        return repository.findAll().stream()
            .map(user -> UserDto.from(user))
            .collect(Collectors.toList());
    }

    /* SIGN UP */
    @Override
    public UserDto signup(UserDto dto) {
        if (repository.findByUsername(dto.getUsername()).isPresent()) {
            throw new DuplicateMemberException("This username is taken. Try another.");
        }

        User entity = dtoToEntity(dto);

        return UserDto.from(repository.save(entity));
    }


    /* LOG IN */
    @Override
    public UserDto login(UserDto dto) {
        Optional<User> user = repository.findByUsername(dto.getUsername());

        if (user.isEmpty()) {
            throw new NotFoundException("Username not found. Try again.");
        }

        else if(!user.get().getPassword().equals(dto.getPassword())) {
            throw new UnauthorizedException("Wrong password. Try again.");
        }
        
        return UserDto.from(user.get());
    }
}
 