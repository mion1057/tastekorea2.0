package com.tastekorea.webapp.common.web.handler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tastekorea.webapp.common.service.UploadResourceManager;
import com.tastekorea.webapp.common.vo.CacheFileResource;


/**
 * <img src=""> 태그의 src에 정의된 이미지 리소스에 대한 처리
 * @author Sage R Lee
 *
 */
@Controller
public class ImageFileResourceHandler{

	@Autowired
	private UploadResourceManager manager;
	
	@GetMapping("/resource/companion/profie/**/{fileName}")
	public ResponseEntity<CacheFileResource> getCompanionProfileImage(@PathVariable 
			String fileName, HttpServletRequest request) throws IOException {

		CacheFileResource resource = createFileResource(
				manager.getUploadRootDir(), fileName, 
				"/resource/companion/profie", request);

		return sendResource(resource);
	}
	
	protected CacheFileResource createFileResource(String path, String fileName, 
			String prefix, HttpServletRequest request) throws IOException {
	
		return new CacheFileResource(new File(path + getSaveDirFromURL(
										prefix, request), fileName));
	}
	
	/**
	 * 클라이언트에게 전달할 최종 리소스를 캐싱 처리한 후 전송한다.
	 * 
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	private ResponseEntity<CacheFileResource> 
					sendResource(CacheFileResource resource) throws IOException{
		return ResponseEntity.ok().cacheControl(
				CacheControl.maxAge(UploadResourceManager.MAX_CACHE_AGE, TimeUnit.SECONDS))
				.lastModified(resource.lastModified())
				.body(resource);
	}
	
	/**
	 * requestURI로부터 날짜값 리턴
	 * 
	 * @param prefix
	 * @param request
	 * @return
	 */
	private String getSaveDirFromURL(String prefix, HttpServletRequest request) {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = ctxPath.isEmpty() ? uri : uri.substring(ctxPath.length());
		String dynamicPath = path.substring(prefix.length());
		
		int slashIndex = 0;
		if(dynamicPath.indexOf("/") != -1) {
			slashIndex = dynamicPath.lastIndexOf("/");
		}
		String saveDir = dynamicPath.substring(0, slashIndex);
		
		return saveDir;
	}
	
}