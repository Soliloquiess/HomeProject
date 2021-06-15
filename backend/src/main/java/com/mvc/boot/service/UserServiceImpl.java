package com.mvc.boot.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.boot.dao.UserDao;
import com.mvc.boot.vo.User;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void userdelete(User member) {
		sqlSession.getMapper(UserDao.class).memberdelete(member);
	}

	@Override
	public void userupdate(User member) {
		sqlSession.getMapper(UserDao.class).memberupdate(member);
	}

	@Override
	public User userdetail(String id) throws Exception {
		return sqlSession.getMapper(UserDao.class).memberdetail(id);
	}

	@Override
	public void join(User member) throws Exception {
		sqlSession.getMapper(UserDao.class).join(member);
	}

	@Override
	public User login(Map<String,String> map) throws Exception {
		return sqlSession.getMapper(UserDao.class).login(map);
	}

}
