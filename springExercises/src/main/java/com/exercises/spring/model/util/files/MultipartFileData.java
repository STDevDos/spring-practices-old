package com.exercises.spring.model.util.files;

import java.io.Serializable;

import lombok.Data;

@Data
public class MultipartFileData implements Serializable {

	private static final long serialVersionUID = 3989818823419352316L;

	private byte[] bytes;
	private String contentType;
	private String originalFilename;
	private Long size;

}
