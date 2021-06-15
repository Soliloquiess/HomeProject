package com.mvc.boot.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.boot.dao.BaseAddressDao;
import com.mvc.boot.vo.BaseAddress;

@Service
public class BaseAddressServiceImpl implements BaseAddressService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BaseAddress> getSido() throws Exception {		
		return sqlSession.getMapper(BaseAddressDao.class).getSido();
	}

	@Override
	public List<BaseAddress> getGugunInSido(String sido) throws Exception {
		return sqlSession.getMapper(BaseAddressDao.class).getGugunInSido(sido);
	}

	@Override
	public List<BaseAddress> getDongInGugun(String gugun) throws Exception {
		return sqlSession.getMapper(BaseAddressDao.class).getDongInGugun(gugun);
	}

}
