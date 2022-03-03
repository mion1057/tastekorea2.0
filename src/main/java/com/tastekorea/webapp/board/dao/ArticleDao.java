package com.tastekorea.webapp.board.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.board.domain.Article;
import com.tastekorea.webapp.common.dao.TasteDao;


/**
 * 
 * @author Sage R Lee
 *
 */
@Repository
public class ArticleDao extends TasteDao{
	
	/**
	 * 신규 Article 등록
	 * 
	 * @param article
	 * @return
	 */
	public Article save(Article article) {
		
		return null;
	}
	
	
	/**
	 * 특정 게시글 조회
	 * 
	 * @param articleId
	 * @return
	 */
	public Article findById(long articleId) {
		
		return null;
	}


	/**
	 * 특정 게시판의 게시글 조회
	 * 
	 * @param articleId
	 * @return
	 */
	public Article findByCategoryAndId(long articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 특정 게시판의 게시글 목록 조회
	 * 
	 * @param category
	 * @param pageable
	 * @return
	 */
	public Page<Article> findArticlesByCategory(int category, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 첨부파일이 없는 게시글의 내용에 대한 정보를 수정
	 * 
	 * @param title
	 * @param content
	 * @param pics
	 * @param video
	 * @param articleId
	 * @return
	 */
	public int updateArticleContent(String title, String content, boolean pics, 
									boolean video, long articleId) {
		
		return 0;
	}

}