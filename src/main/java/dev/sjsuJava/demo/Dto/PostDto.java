package dev.sjsuJava.demo.Dto;

import java.time.LocalDateTime;

import dev.sjsuJava.demo.Entity.Post;
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
    private Long writer_id;
    private String content;
    private String pic_id;
    private Long roars_count;
    private LocalDateTime regDate, modDate;

	public static PostDto from(Post post) {
		if (post == null)
			return null;

		return PostDto.builder()
				.post_id(post.getPost_id())
				.writer_id(post.getWriter().getUser_id())
                .pic_id(post.getPic_id())
				.content(post.getContent())
                .roars_count(post.getRoars_count())
				.regDate(post.getRegDate())
				.modDate(post.getModDate())
				.build();
	}
}