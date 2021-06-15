package com.mvc.boot.vo;

public class QnaBoard {
	int num;
	String name;
	String title;
	String content;
	
	public QnaBoard() {}
	public QnaBoard(int num, String name, String title, String content) {
		this.num = num;
		this.name = name;
		this.title = title;
		this.content = content;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
