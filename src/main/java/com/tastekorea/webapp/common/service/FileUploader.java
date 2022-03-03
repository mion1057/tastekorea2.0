package com.tastekorea.webapp.common.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
@Getter

public class FileUploader {

	@Autowired
	private UploadResourceManager manager;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	/**
	 * 업로드한 파일을 시스템에 설정된 위치에 저장하고 DB에 보관될 경로를 리턴한다.
	 * 
	 * @param multipartFile
	 * @return
	 */
	public String fileUpload(MultipartFile multipartFile) {
		String savedFileName = randomFileName(multipartFile.getOriginalFilename());
		String subDir = dateFormat.format(Calendar.getInstance().getTime());
		String uploadDir = makeUploadDir(manager.getUploadRootDir(), subDir);
		
		Path uploadPath = Paths.get(uploadDir + File.separator + savedFileName);
		try {
			// 업로드된 파일의 inputStream을 읽어 uploadDir (저장위치)로 파일을 기록
			// 필요에 따라 copy의 옵션을 지정할 수 있다.
			// ex) StandardCopyOption.REPLACE_EXISTING은 동일 파일 존재시 대체
			Files.copy(multipartFile.getInputStream(), uploadPath);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("upload file failed : " 
									+ multipartFile.getOriginalFilename());
		}
		
		//uploadRootDir 기준에서 DB에 저장될 경로
		return subDir + "/" + savedFileName;
	}
	
	
	/**
	 * 전달된 원본 파일의 동일 확장자를 가진 임시 파일명을 리턴한다.
	 * 
	 * @param originalFileName	파일 확장자를 포함한 파일명
	 * @return
	 */
	public String randomFileName(String originalFileName) {
		StringBuilder random = new StringBuilder(UUID.randomUUID().toString());
		random.append(".");
		random.append(StringUtils.getFilenameExtension(originalFileName));
		
		return random.toString();
	}
	
	/**
	 * 부모 + 자식 경로에 대한 디렉토리를 존재하지 않는 경우 생성한다.
	 * 
	 * @param parent
	 * @param subDir
	 * @return
	 */
	public String makeUploadDir(String parent, String subDir) {
		File f = new File(StringUtils.cleanPath(parent + File.separator + subDir));
		if(!f.exists()) {
			f.mkdirs();
		}
		return f.getAbsolutePath();
	}
}