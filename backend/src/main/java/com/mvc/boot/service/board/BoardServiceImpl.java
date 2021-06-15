package com.mvc.boot.service.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.boot.dao.BoardDao;
import com.mvc.boot.vo.NewsBoard;
import com.mvc.boot.vo.NoticeBoard;
import com.mvc.boot.vo.QnaBoard;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeBoard> selectAllNotice() {
		return sqlSession.getMapper(BoardDao.class).selectAllNotice();
	}
	
	@Override
	public NoticeBoard selectOneNotice(String num) {
		return sqlSession.getMapper(BoardDao.class).selectOneNotice(num);
	}

	@Override
	public List<NewsBoard> selectAllNews() {
		return sqlSession.getMapper(BoardDao.class).selectAllNews();
	}

	@Override
	public NewsBoard selectOneNews(String num) {
		return sqlSession.getMapper(BoardDao.class).selectOneNews(num);
	}
	@Override
	public List<QnaBoard> selectAll() {
		return sqlSession.getMapper(BoardDao.class).selectAll();
	}

	@Override
	public QnaBoard selectOne(String num) {
		return sqlSession.getMapper(BoardDao.class).selectOne(num);
	}

	@Override
	public void addQna(QnaBoard qna) {
		sqlSession.getMapper(BoardDao.class).addQna(qna);
	}

	@Override
	public void qnaDelete(String num) {
		sqlSession.getMapper(BoardDao.class).qnaDelete(num);
	}

	@Override
	public void qnaUpdate(QnaBoard qna) {
		sqlSession.getMapper(BoardDao.class).qnaUpdate(qna);
	}

}
