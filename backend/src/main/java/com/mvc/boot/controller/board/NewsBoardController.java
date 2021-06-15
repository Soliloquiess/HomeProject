package com.mvc.boot.controller.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.boot.service.board.BoardService;
import com.mvc.boot.vo.NewsBoard;

@RestController
@RequestMapping("/board/news")
@CrossOrigin("*")
public class NewsBoardController {

	private static final Logger logger = LoggerFactory.getLogger(NewsBoardController.class);
	
	@Autowired
	private BoardService BoardService;
	
	@GetMapping(value = "/list")
	@ResponseBody
	public List<NewsBoard> selectAll() throws Exception {
		return BoardService.selectAllNews();
	}
	@GetMapping(value = "/list/{num}")
	@ResponseBody
	public NewsBoard selectOne(@PathVariable String num) throws Exception {
		return BoardService.selectOneNews(num);
	}
}
