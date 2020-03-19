package com.froyo.service.model.dto.files;

import com.froyo.service.model.util.files.MultipartFileData;
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
