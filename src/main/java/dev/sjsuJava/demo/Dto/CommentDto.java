package dev.sjsuJava.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import dev.sjsuJava.demo.Entity.Comment;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDto {
    private Long comment_id;
    private String content;
    private Long post_id;
    private Long commenter_id;
    private LocalDateTime regDate, modDate;

	public static CommentDto from(Comment comment) {
		if (comment == null)
			return null;

		return CommentDto.builder()
				.comment_id(comment.getComment_id())
				.content(comment.getContent())
				.post_id(comment.getPost().getPost_id())
                .commenter_id(comment.getCommenter().getUser_id())
				.regDate(comment.getRegDate())
				.modDate(comment.getModDate())
				.build();
	}
}