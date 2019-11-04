package com.exercises.spring.model.dto.files;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@ToString
public class UploadAlbumRequest implements Serializable {

    private String titleAlbum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAlbum;

}
