package com.mvc.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.boot.service.HouseDealService;
import com.mvc.boot.vo.HouseDeal;
import com.mvc.boot.vo.HouseInfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/deal")
@CrossOrigin("*")
public class HouseDealController {
	@Autowired
	HouseDealService service;
	
	@GetMapping(value="/{dong}")
	public ResponseEntity<List<HouseDeal>> selectAllInDong(@PathVariable String dong){
		List<HouseDeal> list = service.selectAllInDong(dong);
		if(list != null && !list.isEmpty())
			return new ResponseEntity<List<HouseDeal>>(list,HttpStatus.OK);
		else 
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/{aptName}")
	public List<HouseDeal> selectAllByAptName(@PathVariable String aptName){
		List<HouseDeal> a = service.selectAllByAptName(aptName);
		System.out.println(a.get(0).getDong());
		return a;
//		if(list != null && !list.isEmpty())
//			return new ResponseEntity<List<HouseDeal>>(list,HttpStatus.OK);
//		else 
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	/*
	@GetMapping(value="/todo/{no}")
	@ApiOperation(notes="no를 사용해 todolist 검색",value="todolist 검색")
	public ResponseEntity<HouseDeal> selectOne(String no){
		HouseDeal res = service.selectOne(no);
		if(res != null)
			return new ResponseEntity<HouseDeal>(res,HttpStatus.OK);
		else 
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}*/
}
