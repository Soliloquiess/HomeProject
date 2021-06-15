package com.mvc.boot.service.board;

import java.util.List;

import com.mvc.boot.vo.NewsBoard;
import com.mvc.boot.vo.NoticeBoard;
import com.mvc.boot.vo.QnaBoard;

public interface BoardService {

	List<NoticeBoard> selectAllNotice();
	NoticeBoard selectOneNotice(String num);	
	
	List<NewsBoard> selectAllNews();
	NewsBoard selectOneNews(String num);	
	
	List<QnaBoard> selectAll();
	QnaBoard selectOne(String num);
	void addQna(QnaBoard qna);
	void qnaDelete(String num);
	void qnaUpdate(QnaBoard qna);
}
