package com.mvc.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.boot.dao.HouseInfoDao;
import com.mvc.boot.vo.BaseAddress;
import com.mvc.boot.vo.HouseDeal;
import com.mvc.boot.vo.HouseInfo;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {
	@Autowired
	HouseInfoDao dao;

	@Override
	public List<HouseInfo> selectAll(String dong) {
		return dao.selectAll(dong);
	}

	@Override
	public List<HouseInfo> selectAllByAptname(String aptname) {
		return dao.selectAllByAptname(aptname);
	}

	@Override
	public HouseInfo selectOne(int no) {
		return dao.selectOne(no);
	}

}
