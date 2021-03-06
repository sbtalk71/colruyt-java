package com.demo.spring.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ImageGallary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    @Lob
    private byte[] fileByte;

    @Transient
    private String base64Img;
}
