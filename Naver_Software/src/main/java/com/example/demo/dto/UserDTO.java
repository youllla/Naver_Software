package com.example.demo.dto;


import java.time.LocalDateTime;

import com.example.demo.springSecurity.UserEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
	private int userNo; //회원번호(PK)
	private String name; //이름
	private String email; //이메일
	private String password; //비밀번호
	private String tel; //연락처
	private String address; //주소
	private String gender; //성별
	private String interest; //관심분야
	private String role; //권한
	private LocalDateTime regDate; //등록일
	private LocalDateTime updDate; //수정일
	
	public UserEntity toEntity() {
		
		System.out.println("Entity email : " + email);
		System.out.println("Entity password : " + password);
		
		return UserEntity.builder()
				.userNo(userNo)
				.name(name)
				.email(email)
				.password(password)
				.tel(tel)
				.address(address)
				.gender(gender)
				.interest(interest)
				.regDate(regDate)
				.updDate(updDate)
				.build();
	}
	
	@Builder
	public UserDTO(int userNo, String name, String email, String password, String tel, String address, String gender, String interest, String role, LocalDateTime regDate, LocalDateTime updDate) {
		this.userNo = userNo;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.address = address;
		this.gender = gender;
		this.interest = interest;
		//this.role = role;
		this.regDate = regDate;
		this.updDate = updDate;
		
		System.out.println("DTO email : " + email);
		System.out.println("DTO password : " + password);
	}
}
