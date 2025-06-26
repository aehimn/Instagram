package com.haemin.Instagram.user.service;

import org.springframework.stereotype.Service;

import com.haemin.Instagram.common.SHA256HashingEncoder;
import com.haemin.Instagram.user.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		String hashingPassword = SHA256HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, hashingPassword, name, email);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isDuplicateId(String loginId) {
		int count = userRepository.selectCountByLoginId(loginId);
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
}
