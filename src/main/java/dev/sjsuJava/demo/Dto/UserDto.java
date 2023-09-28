package dev.sjsuJava.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
}