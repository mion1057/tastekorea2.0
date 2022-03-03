package com.tastekorea.webapp.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.common.dao.AppReplyDao;
import com.tastekorea.webapp.common.domain.AppReply;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class AppReplyManager {
	
	@Autowired
	private AppReplyDao appReplyDao;
	
	
	/**
	 * 신규 댓글 추가
	 * 
	 * @param appReply
	 * @return
	 */
	public AppReply addAppReply(AppReply appReply) {
		appReply.setId(appReplyDao.saveReply(appReply));
		return appReply;
	}
	
	
	/**
	 * 전달된 서비스의 댓글 목록 조회
	 * 
	 * @param appCode
	 * @param pageable
	 * @return
	 */
	public Page<AppReply> getAppReplyList(int appCode, Pageable pageable){
		return appReplyDao.findParentRepliesByAppCode(appCode, pageable);
	}
	
	
}