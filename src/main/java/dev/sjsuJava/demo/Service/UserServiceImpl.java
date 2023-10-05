package dev.sjsuJava.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.sjsuJava.demo.Dto.UserDto;
import dev.sjsuJava.demo.Entity.Post;
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

    @Override
    public UserDto signup(UserDto dto) {
        if (repository.findByUsername(dto.getUsername()).isPresent()) {
            throw new DuplicateMemberException("This username is taken. Try another.");
        }

        User entity = dtoToEntity(dto);

        return UserDto.from(repository.save(entity));
    }

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

    @Override
    public List<UserDto> readAllUsers() {
        return repository.findAll().stream()
            .map(user -> UserDto.from(user))
            .collect(Collectors.toList());
    }

    @Override
    public UserDto readUser(int id) {
        Optional<User> user = repository.findById((long) id);
        if(user.isEmpty()) {
            throw new NotFoundException();
        }
        return UserDto.from(user.get());
    }

    @Override
    public void update(int id, UserDto dto) {
        Optional<User> OtargetUser = repository.findById((long) id);
        if(OtargetUser.isEmpty()) {
            throw new NotFoundException();
        }

        User targetUser = OtargetUser.get();

        User user = User.builder()
            .user_id(dto.getUser_id() == null ? targetUser.getUser_id() : dto.getUser_id())
            .username(dto.getUsername() == null ? targetUser.getUsername() : dto.getUsername())
            .password(dto.getPassword() == null ? targetUser.getPassword() : dto.getPassword())
            .name(dto.getName() == null ? targetUser.getName() : dto.getName())
            .build();
        
        repository.save(user);
    }

    @Override
    public void delete(int id) {
        Optional<User> user = repository.findById((long) id);
        if(user.isEmpty()) {
            throw new NotFoundException();
        }
        repository.delete(user.get());
    }
}
 