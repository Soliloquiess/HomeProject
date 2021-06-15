package com.mvc.boot.dao;

import java.util.List;

import com.mvc.boot.vo.BaseAddress;

public interface BaseAddressDao {
	List<BaseAddress> getSido() throws Exception;
	List<BaseAddress> getGugunInSido(String sido) throws Exception;
	List<BaseAddress> getDongInGugun(String gugun) throws Exception;
}
