package com.tastekorea.webapp.board.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class ArticleReply extends CommonEntity {
	
	@OneToOne
	@JoinColumn(name="memberId")
	private TasteMember member;				//작성자	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="articleId")
	private Article article;
	
	private Long parentId;					//대댓글인 경우 부모댓글 (null값 허용)
	
	private String comment;					//댓글내용
	private String recipient;				//댓글 수신자
	private int likeCount;					//좋아요, 추천 수
	private int dislikeCount;				//싫어요
	
		
}