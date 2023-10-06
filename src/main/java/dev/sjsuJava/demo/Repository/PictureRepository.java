package dev.sjsuJava.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sjsuJava.demo.Entity.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long>{
    Picture findByStoredFileName(String filename);
}
