package dev.sjsuJava.demo.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import dev.sjsuJava.demo.Dto.PictureDto;
import dev.sjsuJava.demo.Entity.Picture;
import dev.sjsuJava.demo.Repository.PictureRepository;
import dev.sjsuJava.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final PictureRepository repository;

    @Override
    public PictureDto upload(MultipartFile file, String pic_id) {
        Picture pic = new Picture();

        try {
            // 확장자 명이 없으면 이 파일은 잘 못 된 것이다
            String contentType = file.getContentType();
            String originalFileExtension;
            if (ObjectUtils.isEmpty(contentType)) {
                throw new IOException("Empty file extension");
            } else {
                if (contentType.contains("image/jpeg")) {
                    originalFileExtension = ".jpg";
                } else if (contentType.contains("image/png")) {
                    originalFileExtension = ".png";
                } else if (contentType.contains("image/gif")) {
                    originalFileExtension = ".gif";
                }
                // 다른 파일 명이면 아무 일 하지 않는다
                else {
                    throw new IOException("Invalid file extension");
                }
            }
            String newFilename = pic_id + originalFileExtension;
            File fout = new File("src/main/resources/static/pictures/" + newFilename);
            FileOutputStream fos = new FileOutputStream(fout);
            byte[] bytes = file.getBytes();
            fos.write(bytes);
            fos.close();

            pic = Picture.builder()
                    .originalFileName(file.getOriginalFilename())
                    .storedFileName(pic_id)
                    .extension(originalFileExtension)
                    .file_size(file.getSize())
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PictureDto.from(repository.save(pic));
    }

    @Override
    public byte[] getPicByFilename(String filename) {
        Picture pic = repository.findByStoredFileName(filename);

        FileInputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            inputStream = new FileInputStream("src/main/resources/static/pictures/" + filename + pic.getExtension());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try {
            while ((readCount = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readCount);
            }
            fileArray = outputStream.toByteArray();
            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileArray;
    }

    @Override
    public PictureDto getPicture(int id) {
        Optional<Picture> picture = repository.findById((long) id);
        if (picture.isEmpty()) {
            throw new NotFoundException("Picture not found");
        }
        return PictureDto.from(picture.get());
    }

}
