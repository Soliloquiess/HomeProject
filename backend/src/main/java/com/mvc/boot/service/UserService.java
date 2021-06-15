package com.mvc.boot.service;

import java.util.List;
import java.util.Map;

import com.mvc.boot.vo.User;

public interface UserService {

	void userdelete(User member);
	void userupdate(User member);
	User userdetail(String id) throws Exception;
	void join(User member) throws Exception;
	User login(Map<String,String> map) throws Exception;
}
