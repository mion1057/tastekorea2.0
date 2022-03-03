package com.tastekorea.webapp.board.web.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {
	//게시판 정보 Identity
	private int categoryId;
	private String alias;
	private String korName;
	private String engName;
	
	//게시글 정보 Identity
	private long articleId;
	
	//요청 정보 Identity
	private String referer;
	private String uri;
	private String contentUrl;
	
	public BoardRequest() {
		
	}
}