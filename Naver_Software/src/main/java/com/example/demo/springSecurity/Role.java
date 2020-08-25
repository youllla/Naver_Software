package com.example.demo.springSecurity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	private String value;
}
