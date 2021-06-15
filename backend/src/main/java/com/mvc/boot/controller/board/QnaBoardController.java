package com.mvc.boot.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.boot.service.board.BoardService;
import com.mvc.boot.vo.QnaBoard;

@RestController
@RequestMapping("/board/qna")
@CrossOrigin("*")
public class QnaBoardController {

	private static final Logger logger = LoggerFactory.getLogger(QnaBoardController.class);
	
	@Autowired
	private BoardService qnaBoardService;
	
	@GetMapping(value = "/list")
	@ResponseBody
	public List<QnaBoard> selectAll() throws Exception {
		return qnaBoardService.selectAll();
	}
	@GetMapping(value = "/list/{num}")
	@ResponseBody
	public QnaBoard selectOne(@PathVariable String num) throws Exception {
		return qnaBoardService.selectOne(num);
	}
	
	@PostMapping(value="/add")
	@ResponseBody
	public void add(HttpServletRequest request, @RequestBody QnaBoard qna, Model model) {
		qnaBoardService.addQna(qna);
	}
	
	@PutMapping(value="/update")
	@ResponseBody
	public void updateQna(HttpServletRequest request, QnaBoard qna, Model model) {
		qnaBoardService.qnaUpdate(qna);		
	}
	
	@DeleteMapping(value="/delete/{num}")
	public void deleteQna(@PathVariable String num) throws Exception {
		qnaBoardService.qnaDelete(num);
	}
	
}
