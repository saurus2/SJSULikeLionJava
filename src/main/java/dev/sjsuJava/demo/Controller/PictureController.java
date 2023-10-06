package dev.sjsuJava.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.sjsuJava.demo.Dto.PictureDto;
import dev.sjsuJava.demo.Service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/picture")
public class PictureController {
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);
    private final PictureService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PictureDto> savePicture(
            @RequestParam MultipartFile file,
            @RequestParam String pic_id) {
        logger.info("pic_id: " + pic_id);
        return ResponseEntity.ok(service.upload(file, pic_id));
    }

    @GetMapping("{id}")
    public ResponseEntity<PictureDto> getPicture(@PathVariable int id) {
        return ResponseEntity.ok(service.getPicture(id));
    }

    @GetMapping(value = "download/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getPicByFilename(@PathVariable String filename) {
        return ResponseEntity.ok(service.getPicByFilename(filename));
    }
}
