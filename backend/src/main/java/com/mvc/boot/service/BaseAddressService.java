package com.mvc.boot.service;

import java.util.List;

import com.mvc.boot.vo.BaseAddress;

public interface BaseAddressService {
	List<BaseAddress> getSido() throws Exception;
	List<BaseAddress> getGugunInSido(String sido) throws Exception;
	List<BaseAddress> getDongInGugun(String gugun) throws Exception;
}
