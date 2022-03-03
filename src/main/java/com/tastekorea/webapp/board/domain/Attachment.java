package com.tastekorea.webapp.board.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@ToString(exclude= {"article"})
public class Attachment extends CommonEntity {
	
	@ManyToOne
	@JoinColumn(name="articleId")
	private Article article;
	
	private String filePath;			//경로+시스템 파일명
	private String fileName;			//원본 파일명
	private long fileSize;				//크기(KB)
}