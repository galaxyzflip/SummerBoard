package net.nice19.smboard.dao;

import java.util.List;

import net.nice19.smboard.board.model.BoardCommentModel;
import net.nice19.smboard.board.model.BoardModel;

public interface BoardDao {

	
	 //JMboard 테이블에서
	
	//전체 글 검색
	List<BoardModel> getBoardList(int startArticleNum, int showArticleLimit);
	
	
	//아티클 상세 보여주기용
	BoardModel getOneArticle(int idx);
	
	
	//아티클 검색
	List<BoardModel> searchArticle(String type, String keyword, int startArticleNum, int endArticleNum);
	
	
	//댓글 리스트
	List<BoardCommentModel> getCommentList(int idx);
	
	
	//
	BoardCommentModel getOneComment(int idx);
	
	
	
	boolean modifyArticle(BoardModel board);
	
	boolean writeArticle(BoardModel board);
	
	boolean writeComment(BoardCommentModel comment);
	
	void updateHitcount(int hitcount, int idx);
	
	void updateRecommendCount(int recommendcount, int idx);
	
	int getTotalNum();
	
	int getSearchTotalNum(String type, String keyword);
	
	void deleteComment(int idx);
	
	void deleteArticle(int idx);
	
	
}
