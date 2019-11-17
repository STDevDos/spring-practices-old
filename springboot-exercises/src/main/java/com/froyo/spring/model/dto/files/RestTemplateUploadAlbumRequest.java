package com.froyo.spring.model.dto.files;

import com.froyo.spring.model.util.files.MultipartFileData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
public class RestTemplateUploadAlbumRequest {

    private List<MultipartFileData> photos;
    private UploadAlbumRequest uploadAlbumRequest;

}
