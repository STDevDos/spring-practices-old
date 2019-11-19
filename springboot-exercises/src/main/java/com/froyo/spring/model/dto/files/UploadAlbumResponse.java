package com.froyo.spring.model.dto.files;

import com.froyo.messages.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class UploadAlbumResponse extends AbstractResponse {
    private static final long serialVersionUID = -7785927162545658854L;

    private RestTemplateUploadAlbumRequest restTemplateUploadAlbumRequest;
}
