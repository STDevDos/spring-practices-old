package com.exercises.spring.model.dto.files;

import com.exercises.spring.model.util.messages.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class UploadAlbumResponse extends AbstractResponse implements Serializable {
    private RestTemplateUploadAlbumRequest restTemplateUploadAlbumRequest;
}
