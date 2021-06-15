package com.mvc.boot.dao;

import java.util.List;

import com.mvc.boot.vo.HouseDeal;
import com.mvc.boot.vo.HouseInfo;

public interface HouseDealDao {
	public List<HouseDeal> selectAllInDong(String dong);
	public List<HouseDeal> selectAllByAptName(String aptName);
	//public HouseDeal selectOne(String no); 
}
