package com.mvc.boot.service;

import java.util.List;

import com.mvc.boot.vo.HouseDeal;
import com.mvc.boot.vo.HouseInfo;

public interface HouseDealService {
	public List<HouseDeal> selectAllInDong(String dong);
	public List<HouseDeal> selectAllByAptName(String aptName);
	//public HouseDeal selectOne(String no);
}
