package com.tastekorea.webapp.common.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@ToString(exclude= {"traveler"})
public class AppReply extends CommonEntity{
	
	private long masterId;					//댓글에 대한 콘텐츠 리소스
	
	//부모 댓글 id
	//댓글과 대댓글의 구분을 부모 댓글 id 존재 유무로 판단한다.
	// NULL값을 가질 수 있는 FK이어야 한다.
	private Long parentId;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	private TasteMember member;				//작성자		
	private int appCode;
	
	private String comment;					//댓글내용
	private String recipient;				//댓글 수신자 별명
	private int priority = 100;
	private int likeCount;					//좋아요, 추천 수
	private int dislikeCount;				//싫어요
	
	
	@Override
	public String toString() {
		return "AppReply [masterId=" + masterId + ", parentId=" + parentId 
				+ ", member=" + member.getAlias()
				+ " (" + member.getProfileImage() + "), appCode=" + appCode 
				+ ", comment=" + comment + ", recipient=" + recipient 
				+ ", priority=" + priority + ", likeCount=" + likeCount 
				+ ", dislikeCount=" + dislikeCount + "]";
	}
	
	
}