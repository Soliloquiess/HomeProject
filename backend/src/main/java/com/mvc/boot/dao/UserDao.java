package com.mvc.boot.dao;

import java.util.Map;

import com.mvc.boot.vo.User;

public interface UserDao {

	void memberdelete(User member);
	void memberupdate(User member);
	User memberdetail(String id) throws Exception;
	void join(User member) throws Exception;
	void logout() throws Exception;
	User login(Map<String,String> map) throws Exception;
}
