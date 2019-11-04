package com.exercises.spring.model.util.files;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MultipartFileUtil {

    private MultipartFileUtil() {
        throw new UnsupportedOperationException();
    }

    public static MultipartFileData dataSerializable(MultipartFile multipartFile) throws IOException {
        MultipartFileData multipartFileData = new MultipartFileData();
        multipartFileData.setBytes(multipartFile.getBytes());
        multipartFileData.setContentType(multipartFile.getContentType());
        multipartFileData.setOriginalFilename(multipartFile.getOriginalFilename());
        multipartFileData.setSize(multipartFile.getSize());
        return multipartFileData;
    }

}
