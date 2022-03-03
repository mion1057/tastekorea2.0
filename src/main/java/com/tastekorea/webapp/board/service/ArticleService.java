package com.tastekorea.webapp.board.service;

import com.tastekorea.webapp.board.domain.Article;

public interface ArticleService {

	/**
	 * 신규 Article 등록
	 * 
	 * @param article
	 * @return
	 */
	Article addArticle(Article article);

}