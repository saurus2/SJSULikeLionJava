package dev.sjsuJava.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import dev.sjsuJava.demo.Entity.User;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long user_id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime regDate, modDate;

	public static UserDto from(User user) {
		if (user == null)
			return null;

		return UserDto.builder()
				.user_id(user.getUser_id())
				.username(user.getUsername())
                .password(user.getPassword())
				.name(user.getName())
				.regDate(user.getRegDate())
				.modDate(user.getModDate())
				.build();
	}
}