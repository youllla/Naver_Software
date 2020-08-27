package com.example.demo.service;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.UserDTO;
import com.example.demo.springSecurity.Role;
import com.example.demo.springSecurity.UserEntity;
import com.example.demo.springSecurity.UserRepository;
import com.example.demo.util.EmailSender;

import groovy.util.logging.Log;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int joinUser(UserDTO userDTO) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		
		//DB insert 성공 여부
		int result = userRepository.save(userDTO.toEntity()).getUserNo();
		
		System.out.println("result : " + result);
		
		//수정 필요
		if (result == (userDTO.toEntity()).getUserNo()) {
			EmailSender.sendEmail();
		}
		
		return result;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserEntity> userEntityWrapper = userRepository.findByEmail(email);
		UserEntity userEntity = userEntityWrapper.get();
		
		System.out.println("userEntityWrapper : " + userEntityWrapper);
		System.out.println("userEntity : " + userEntity);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		System.out.println("authorities : " + authorities);
		
		System.out.println("service email : " + email);
		System.out.println("service email2 : " + userEntity.getEmail());
		System.out.println("service pwd : " + userEntity.getPassword());
		//UserDTO userDTO = new UserDTO();
		
		//if(userDTO.getRole() == "1") { //조건 수정
		if(("admin@email.com").equals(email)) { //조건 수정
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
		}
		
		return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
	}
}
