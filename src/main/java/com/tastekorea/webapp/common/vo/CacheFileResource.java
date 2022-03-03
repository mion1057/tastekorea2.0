package com.tastekorea.webapp.common.vo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

import org.springframework.core.io.FileSystemResource;

import lombok.Getter;
import lombok.Setter;

/**
 * FileResource에 대해 편리한 캐시 처리를 할 수 있도록 FileSystemResource를 캡슐화
 * 
 * 
 * ------- path : C:\Upload\FICO\WorkBook\note\2021\12\30\1653_DPfCCFm7NImx143.jpg
 * ------- name : 1653_DPfCCFm7NImx143.jpg
 * 
 * @author "Kaminish"
 *
 */

@Getter
@Setter
public class CacheFileResource extends FileSystemResource{
	private String fileName;
	private String filePath;
	private long lastModified;
	
	public CacheFileResource(File file) throws IOException {
		super(file);
		this.fileName = file.getName();
		this.filePath = file.getPath();
		
		Path path = Paths.get(filePath);
		FileTime fileTime = Files.getLastModifiedTime(path);
		this.lastModified = fileTime.toMillis();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CacheFileResource other = (CacheFileResource) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}
}