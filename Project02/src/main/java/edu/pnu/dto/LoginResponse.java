package edu.pnu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
	private String userid;
	private String username;

    public LoginResponse(String userid, String username) {
    	this.userid = userid;
    	this.username = username;
    }
}
