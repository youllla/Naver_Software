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

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int joinUser(UserDTO userDTO) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		
		return userRepository.save(userDTO.toEntity()).getUserNo();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserEntity> userEntityWrapper = userRepository.findByEmail(email);
		UserEntity userEntity = userEntityWrapper.get();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		UserDTO userDTO = new UserDTO();
		
		if(userDTO.getRole() == "1") { //조건 수정
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
		}
		
		return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
	}
}
