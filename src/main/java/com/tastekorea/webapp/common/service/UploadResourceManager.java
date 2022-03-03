package com.tastekorea.webapp.common.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = { "classpath:application.properties" })
public class UploadResourceManager {

	public static final int MAX_CACHE_AGE = 2592000;

	@Value(value = "${file.upload.dir}")
	private java.lang.String uploadRootDir;

	public String getUploadRootDir() {
		return uploadRootDir;
	}

}