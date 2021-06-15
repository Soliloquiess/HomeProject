package com.mvc.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.boot.dao.HouseDealDao;
import com.mvc.boot.vo.HouseDeal;
import com.mvc.boot.vo.HouseInfo;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	@Autowired
	HouseDealDao dao;

	@Override
	public List<HouseDeal> selectAllInDong(String dong) {
		return dao.selectAllInDong(dong);
	}

	@Override
	public List<HouseDeal> selectAllByAptName(String aptName) {
		return dao.selectAllByAptName(aptName);
	}

}
