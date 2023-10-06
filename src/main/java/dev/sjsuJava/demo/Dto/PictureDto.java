package dev.sjsuJava.demo.Dto;

import java.time.LocalDateTime;

import dev.sjsuJava.demo.Entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PictureDto {
    private Long id;
    private String originalFileName;
    private String storedFileName;
    private String extension;
    private long file_size;
    private LocalDateTime regDate, modDate;

    public static PictureDto from(Picture pic) {
        if (pic == null)
            return null;

        return PictureDto.builder()
                .id(pic.getId())
                .originalFileName(pic.getOriginalFileName())
                .storedFileName(pic.getStoredFileName())
                .extension(pic.getExtension())
                .file_size(pic.getFile_size())
                .regDate(pic.getRegDate())
                .modDate(pic.getModDate())
                .build();
    }
}
