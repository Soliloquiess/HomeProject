package com.mvc.boot.dao;

import java.util.List;

import com.mvc.boot.vo.BaseAddress;
import com.mvc.boot.vo.HouseInfo;

public interface HouseInfoDao {
	public List<HouseInfo> selectAll(String dong);
	public List<HouseInfo> selectAllByAptname(String aptname);
	public HouseInfo selectOne(int no);
}
