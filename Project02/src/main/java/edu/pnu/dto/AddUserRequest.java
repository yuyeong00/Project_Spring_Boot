package edu.pnu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
	private String userid;
    private String username;
    private String password;
}
