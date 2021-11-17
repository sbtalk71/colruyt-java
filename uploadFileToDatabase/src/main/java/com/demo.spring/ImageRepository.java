package com.demo.spring;


import com.demo.spring.models.ImageGallary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository  extends JpaRepository<ImageGallary,Long> {
    Optional<ImageGallary> findByName(String filename);
}
