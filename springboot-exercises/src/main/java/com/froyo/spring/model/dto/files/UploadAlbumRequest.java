package com.froyo.spring.model.dto.files;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UploadAlbumRequest implements Serializable {

    private static final long serialVersionUID = -322061710855948063L;

    private String titleAlbum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAlbum;

}
