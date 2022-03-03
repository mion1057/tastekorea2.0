package com.tastekorea.webapp.common.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 
 * @author Sage R Lee
 *
 * @param <T>
 */

@Getter
@Setter
@ToString(exclude = "pageList")
public class PageMaker<T> {
	private static final int PAGE_NAVI_SIZE = 3;
	private Page<T> result;

	private Pageable prevPage;
	private Pageable nextPage;
	private Pageable currentPage;
	private List<Pageable> pageList;	//page-number 목록

	private int currentPageNum;
	private int totalPageNum;
	private long totalElements;
	
	private int pageSize;

	public PageMaker(Page<T> result) {
		this.result = result;
		this.currentPage = result.getPageable();
		this.currentPageNum = currentPage.getPageNumber() + 1;
		this.totalPageNum = result.getTotalPages();
		this.totalElements = result.getTotalElements();

		this.pageList = new ArrayList<>();
		this.pageSize = currentPage.getPageSize();

		calcPages();
	}

	private void calcPages() {
		//한 단위 PAGE_NAVI를 지정한다.
		int tempEndNum = (int) (Math.ceil(this.currentPageNum / 10.0) * PAGE_NAVI_SIZE);
		int pageStartNum = tempEndNum - (PAGE_NAVI_SIZE-1);
		Pageable startPage = this.currentPage;

		// 현재 페이지 번호로부터 출발지인 pageStartNum까지 Pageble객체를 리턴받는다.
		// 루핑이 끝나면 startPage는 pageStartNum에 대한 Pageable로 커서가 된다.
		// 이 루핑을 통해 [number: 0, size 20, sort: regDate: DESC]을 저장하게 된다.
		for (int i = pageStartNum; i < this.currentPageNum; i++) {
			startPage = startPage.previousOrFirst();
		}
		//이전 페이지에 대한 Pageable를 설정한다.
		this.prevPage = startPage.getPageNumber() <= 0 ? null
				: startPage.previousOrFirst();

		
		//tempEndNum은 totalPageNum보다 커야할 필요가 없다.
		if (this.totalPageNum < tempEndNum) {
			tempEndNum = this.totalPageNum;
			this.nextPage = null;
		}
		//현재 startPage는 [number: 0, size 20, sort: regDate: DESC]이다.
		//pageStartNum에서부터 PAGE_NAVI끝까지 pageList에 저장한다.
		//루핑이 끝나면 startPage는 PAGE_NAVI 끝의 커서로가 된다.
		for (int i = pageStartNum; i <= tempEndNum; i++) {
			pageList.add(startPage);
			startPage = startPage.next();
		}
		
		//위의 루핑이 끝나면 startPage는 [number: 10, size 20, sort: regDate: DESC]을 저장하게 된다.
		this.nextPage = startPage.getPageNumber() + 1 <= totalPageNum ? startPage
				: null;
	}
}