package com.tastekorea.webapp.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.tastekorea.webapp.board.BoardConstants.*;


import com.tastekorea.webapp.board.dao.ArticleDao;
import com.tastekorea.webapp.board.domain.Article;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	
	/**
	 * 신규 Article 등록
	 * 
	 * @param article
	 * @return
	 */
	@Override
	public Article addArticle(Article article) {
		return articleDao.save(article);
	}
	
	
	/**
	 * 특정 게시글 조회
	 * 
	 * @param articleId
	 * @return
	 */
	public Article getArticle(long articleId) {
		return articleDao.findById(articleId);
	}


	/**
	 * 특정 게시판의 게시글 조회
	 * 
	 * @param articleId
	 * @return
	 */
	public Article getArticle(int category, long articleId) {
		return articleDao.findByCategoryAndId(articleId);
	}
	
	
	
	/**
	 * 특정 게시판의 게시글 목록 조회
	 * 목록정보 : 게시글id, 제목, 작성자, 등록일
	 * 
	 * @param category
	 * @param pageable
	 * @return
	 */
	public Page<Article> getArticleListByCategory(int category, Pageable pageable){
		return articleDao.findArticlesByCategory(category, pageable);
	}
	
	
	/**
	 * 특정 게시판의 게시글 목록 조회
	 * 
	 * @param category
	 * @param page
	 * @return
	 */
	public Page<Article> getArticleListByCategory(int category, int page){
		Pageable pageable = PageRequest.of(page - 1, BOARD_FETCH_SIZE, 
											Sort.Direction.DESC, "regDate");
		return getArticleListByCategory(category, pageable);
	}
	
	
	/**
	 * 게시글의 기본 정보(제목, 콘텐츠)들을 수정한다.
	 * 첨부 파일을 가진 게시글 수정은 삭제 후 재업로드 방식으로 처리한다.
	 * 
	 * @param article
	 * @return
	 */
	@Transactional
	public Article modifyArticle(Article article) {
		//Article의 경우
		if (article.getAttachedFiles() == null || 
				article.getAttachedFiles().isEmpty()) {
			
			articleDao.updateArticleContent(article.getTitle(), article.getContent(), 
					article.isPics(), article.isVideo(), article.getId());
			
			return getArticle(article.getCategory(), article.getId());
		}
		
		//Article + Attachment의 경우
		//1) Article만 수정하는 경우
		//2) 첨부파일만 수정하는 경우
		//3) Artilce + 첨부파일 함께 수정하는 경우
		return null;
	}
}