package com.mvc.boot.dao;

import java.util.List;

import com.mvc.boot.vo.NewsBoard;
import com.mvc.boot.vo.NoticeBoard;
import com.mvc.boot.vo.QnaBoard;

public interface BoardDao {

	public List<NoticeBoard> selectAllNotice();
	public NoticeBoard selectOneNotice(String num);	
	
	public List<NewsBoard> selectAllNews();
	public NewsBoard selectOneNews(String num);	
	
	public List<QnaBoard> selectAll();
	public QnaBoard selectOne(String num);
	void addQna(QnaBoard qna);
	void qnaDelete(String num);
	void qnaUpdate(QnaBoard qna);
}
