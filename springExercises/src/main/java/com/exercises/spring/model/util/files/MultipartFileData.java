package com.exercises.spring.model.util.files;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class MultipartFileData implements Serializable {

    private byte[] bytes;
    private String contentType;
    private String originalFilename;
    private Long size;

}
