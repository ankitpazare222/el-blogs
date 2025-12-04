package com.Ankit.blog.services;

import java.util.List;

import com.Ankit.blog.Dto.UserDto;

public interface UserService {
	
	
	UserDto createUser(UserDto User);
	
	UserDto updateUser(UserDto user,Integer UserID);
	
	UserDto gteUserByID(Integer UserID);
	
	List<UserDto> getallUser();
	
	void deleteUser(Integer UserID);

}
