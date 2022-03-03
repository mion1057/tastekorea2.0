package com.tastekorea.webapp.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;

/**
 * Article은 첨뷰 파일 유무와 관계없이 하나의 게시글을 캡슐화한다.
 * 
 * [Article]1 <-------> *[AttachmentRepository]
 * [Article]1 <-------> *[ArticleReply]
 * [Article]* <-------> 1[TasteMember]
 * 
 * @author Sage R Lee
 *
 */
@Entity
@Setter
@Getter
public class Article extends CommonEntity{
	
	private String title;							//제목
	@Basic(fetch=FetchType.LAZY)
	private String content;							//내용
	private int hits;								//조회수
	private int likeCount;							//좋아요, 추천 수
	private Integer category;						//게시판 종류
	private boolean pinned;							//상단고정
	private boolean pics;							//이미지 등록 여부
	private boolean video;							//영상 등록 여부
	
	@ManyToOne
	@JoinColumn(name="memberId")
	private TasteMember member;						//작성자
	
	@OneToMany(cascade={ CascadeType.ALL})
	@JoinColumn(name="articleId")
	private List<Attachment> attachedFiles = new ArrayList<>();	//첨부파일 목록
	
	@OneToMany(mappedBy="article")
	private List<ArticleReply> replies = new ArrayList<>();		//댓글목록
	
	
	//------------------------------
	// 			양방향 설정
	//------------------------------
	public void addAttachment(Attachment file) {
		if(file != null && !attachedFiles.contains(file)) {
			attachedFiles.add(file);
		}
	}
}