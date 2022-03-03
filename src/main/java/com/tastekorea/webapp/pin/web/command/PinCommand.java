package com.tastekorea.webapp.pin.web.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tastekorea.webapp.common.domain.AppReply;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author "rohyh"
 *
 */
@Getter
@Setter
public class PinCommand {

	// ------------------------
	// Pin을 등록한 가이드 정보
	// ------------------------
	private long member;

	// ------------------------
	// 지역 ex)서울, 부산, 데구 등등
	// ------------------------
	private long region;

	// ------------------------
	// 미리 정의된 관련 특성,속성등을 선택하여
	// 정렬, 구분에 용이성
	// ------------------------
	private long category;

	// ------------------------
	// 댓글
	// ------------------------
	private List<AppReply> replyList;

	// ------------------------
	// 사진, 제목, 상세정보
	// ------------------------
	private MultipartFile imagePath;
	private String title;
	private String description;

	// ------------------------
	// 지도 정보
	// ------------------------
	private String mapData;
	
	private int like;
	private int dislike;

}
