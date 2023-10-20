package dev.sjsuJava.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import dev.sjsuJava.demo.Entity.Roar;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoarDto {
    private Long roar_id;
    private Long commenter_id;
    private Long post_id;
    private LocalDateTime regDate, modDate;

    public static RoarDto from(Roar roar) {
        if (roar == null)
            return null;

        return RoarDto.builder()
                .roar_id(roar.getRoar_id())
                .commenter_id(roar.getCommenter().getUser_id())
                .post_id(roar.getPost().getPost_id())
                .regDate(roar.getRegDate())
                .modDate(roar.getModDate())
                .build();
    }
}