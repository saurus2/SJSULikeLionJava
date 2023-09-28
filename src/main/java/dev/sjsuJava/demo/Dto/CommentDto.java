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
public class CommentDto {
    private Long comment_id;
    private Long post_id;
    private String commenter;
    private String content;
    private LocalDateTime regDate, modDate;
}