package dev.sjsuJava.demo.Service;

import org.springframework.web.multipart.MultipartFile;

import dev.sjsuJava.demo.Dto.PictureDto;

public interface PictureService {
    PictureDto upload(MultipartFile file, String pic_id);

    PictureDto getPicture(int id);

    byte[] getPicByFilename(String filename);
}
