package com.Ankit.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.blog.Dto.UserDto;
import com.Ankit.blog.etities.User;
import com.Ankit.blog.exceptions.ResourceNotFundException;
import com.Ankit.blog.repo.UserRepo;
import com.Ankit.blog.services.UserService;

import lombok.Getter;
import lombok.Setter;
@Service				
public class UserImpl implements UserService {
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public UserDto createUser(UserDto UserDto) {
		
		User user=this.DtoToentity(UserDto);
		User saveUser = this.userrepo.save(user);
		
		// TODO Auto-generated method stub
		return this.EntitytoDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer UserID) {
		// TODO Auto-generated method stub\
		
		User users=this.userrepo.findById(UserID).orElseThrow(() 
				-> new ResourceNotFundException("User", "ID", UserID));
		
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		users.setAbout(userDto.getAbout());
		User updatedUser = this.userrepo.save(users);
		UserDto UserDto1 = this.EntitytoDto(updatedUser);
		return UserDto1;
	}

	@Override
	public UserDto gteUserByID(Integer UserID) {
		// TODO Auto-generated method stub
		User users=this.userrepo.findById(UserID).orElseThrow(() 
				-> new ResourceNotFundException("User", "ID", UserID));
		
		UserDto entitytoDto = this.EntitytoDto(users);
		return entitytoDto;
	}

	@Override
	public List<UserDto> getallUser() {
		// TODO Auto-generated method stub
		List<User> Allusers = this.userrepo.findAll();
		List<UserDto> UsersDtos = Allusers.stream().map(user->this.EntitytoDto(user)).collect(Collectors.toList());
		
		
		return UsersDtos;
	}

	@Override
	public void deleteUser(Integer UserID) {
		// TODO Auto-generated method stub
		User users=this.userrepo.findById(UserID).orElseThrow(() 
				-> new ResourceNotFundException("User", "ID", UserID));
		this.userrepo.delete(users);
		
	}
	private User DtoToentity(UserDto UserDto) {
		
		User user=this.modelmapper.map(UserDto, User.class);
//		user.setID(UserDto.getID());
//		user.setAbout(UserDto.getAbout());
//		user.setEmail(UserDto.getEmail());
//		user.setName(UserDto.getName());
//		user.setPassword(UserDto.getPassword());
		
		return user;
		
	}
	
	private UserDto EntitytoDto(User User) {
		
		UserDto userDto=this.modelmapper.map(User, UserDto.class);
//		userDto.setID(User.getID());
//		userDto.setAbout(User.getAbout());
//		userDto.setEmail(User.getEmail());
//		userDto.setName(User.getName());
//		userDto.setPassword(User.getPassword());
		
		return userDto;
		
	}

}
