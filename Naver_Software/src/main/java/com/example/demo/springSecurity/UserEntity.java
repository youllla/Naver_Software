package com.example.demo.springSecurity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNo;
	
	@Column(length = 10, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 100, nullable = true)
	private String tel;
	
	@Column(length = 100, nullable = true)
	private String address;
	
	@Column(length = 10, nullable = true)
	private String gender;
	
	@Column(length = 100, nullable = true)
	private String interest;
	
	@Column(length = 10, nullable = false)
	private String role;
	
	@CreatedDate
	@Column(length = 100, nullable = false)
	private LocalDateTime regDate;
	
	@LastModifiedDate
	@Column(length = 100, nullable = false)
	private LocalDateTime updDate;
	
	@Builder
	public UserEntity(int userNo, String name, String email, String password, LocalDateTime regDate, LocalDateTime updDate) {
		this.userNo = userNo;
		this.name = name;
		this.email = email;
		this.password = password;
		this.regDate = regDate;
		this.updDate = updDate;
	}

}