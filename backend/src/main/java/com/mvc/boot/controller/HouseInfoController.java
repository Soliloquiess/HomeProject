package com.mvc.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.boot.service.BaseAddressService;
import com.mvc.boot.service.HouseInfoService;
import com.mvc.boot.vo.BaseAddress;
import com.mvc.boot.vo.HouseInfo;

@RestController
@RequestMapping("/house")
@CrossOrigin("*")
public class HouseInfoController {
	@Autowired
	HouseInfoService service;
	@Autowired
	BaseAddressService baseAddressService; 
	
	@GetMapping(value="/info")
	public ResponseEntity<List<HouseInfo>> selectAll(String dong){
		List<HouseInfo> list = service.selectAll(dong);
		if(list != null && !list.isEmpty())
			return new ResponseEntity<List<HouseInfo>>(list,HttpStatus.OK);
		else 
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value="/infobyname")
	public ResponseEntity<List<HouseInfo>> selectAllByAptname(String aptname){
		List<HouseInfo> list = service.selectAllByAptname(aptname);
		if(list != null && !list.isEmpty())
			return new ResponseEntity<List<HouseInfo>>(list,HttpStatus.OK);
		else 
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value="/infobyno/{no}")
	public HouseInfo selectOne(@PathVariable int no){
//		int no = Integer.parseInt(num);
		System.out.println(no);
		HouseInfo a = service.selectOne(no);
		System.out.println(a.getAptName());
		return a;
	}
	@GetMapping(value = "/sido")
	@ResponseBody
	public List<BaseAddress> getSido() throws Exception {
		return baseAddressService.getSido();
	}
	
	@GetMapping(value = "/gugun")
	@ResponseBody
	public List<BaseAddress> getGugunInSido(@RequestParam String sido) throws Exception {
		return baseAddressService.getGugunInSido(sido);
	}
	
	@GetMapping(value = "/dong")
	@ResponseBody
	public List<BaseAddress> getDongInGugun(@RequestParam String gugun) throws Exception {
		return baseAddressService.getDongInGugun(gugun);
	}
}
