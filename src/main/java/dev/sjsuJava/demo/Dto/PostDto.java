package dev.sjsuJava.demo.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {
    private Long post_id;
    private String writer;
    private String title;
    private String description;
    private String pic_id;
    private Long roars_count;
    private LocalDateTime regDate, modDate;
}