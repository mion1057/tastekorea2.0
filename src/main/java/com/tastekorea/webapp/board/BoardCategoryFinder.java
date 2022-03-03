package com.tastekorea.webapp.board;

import javax.servlet.http.HttpServletRequest;

import com.tastekorea.webapp.common.util.StringUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BoardCategoryFinder {
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getBoardAlias(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = ctxPath.isEmpty() ? uri : uri.substring(ctxPath.length());
		String boardPath = null;
		
		if(path.startsWith(BoardConstants.BOARD_PATH)) {
			boardPath = StringUtil.substring(path, BoardConstants.BOARD_PATH);
		}
		
		String boardAlias = boardPath.substring(0, boardPath.lastIndexOf("/"));
		
		log.debug("Board Alias 찾기 : \n\t1) uri : "+uri
				+"\n\t2) ctxPath : "+ctxPath
				+"\n\t3) path : "+path
				+"\n\t4) boardPath : "+boardPath 
				+"\n\t5) boardAlias : "+boardAlias);
		
		
		if(!StringUtil.isEmpty(boardAlias)) {
			return boardAlias;
		}
		
		return "기본board";
	}
}