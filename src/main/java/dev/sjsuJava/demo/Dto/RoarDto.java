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
public class RoarDto {
    private Long roar_id;
    private Long user_id;
    private Long post_id;
    private LocalDateTime regDate, modDate;
}