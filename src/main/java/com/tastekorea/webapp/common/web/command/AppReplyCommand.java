package com.tastekorea.webapp.common.web.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppReplyCommand {
	   private String comment;            //코멘트
	   private int appCode;
	   
	   //작성자 정보 (get from userContainer)
	   private long memberId;            //작성자 
	   private String alias;            //작성자 별명
	   
	   //수신자 정보
	   private String recipient;         //댓글 수신자
	   private long parentId;            //댓글인 경우 0, 대댓글인 경우 부모 댓글id
	   private long masterId;            //댓글의 콘텐츠 리소스 id
	   
	}