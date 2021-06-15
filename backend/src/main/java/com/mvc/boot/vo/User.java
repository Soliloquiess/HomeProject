package com.mvc.boot.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class User {

	private String ID;	
	private String PASS;
	private String NAME;
	private String ROLES;
	
	public User(String ID,String PASS, String NAME, String ROLES) {
		this.ID = ID;
		this.PASS = PASS;
		this.NAME = NAME;
		this.ROLES = ROLES;
	}
}
