package com.Ankit.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.blog.Dto.UserDto;
import com.Ankit.blog.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


		@RestController
		@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto){
		UserDto CreateUserDto = this.userService.createUser(userDto);
		return new  ResponseEntity<UserDto>(CreateUserDto,HttpStatus.CREATED);
		
		
		
		
	}
	@PutMapping("/{UserID}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("UserID") Integer UserId){
		UserDto updateUser = this.userService.updateUser(userDto, UserId);
		return ResponseEntity.ok(updateUser);
	}
	
	
	@DeleteMapping("/{UserID}")
	public ResponseEntity<?> deleteBYiD( @PathVariable("UserID") Integer UserId){
		this.userService.deleteUser(UserId);
		return new  ResponseEntity(Map.of("meaasage","user deleted sucessfully"),HttpStatus.OK);
		
	}
	@GetMapping
	public ResponseEntity<List<UserDto>> getalluser(){
		List<UserDto> getallUser = this.userService.getallUser();
		return ResponseEntity.ok(getallUser);
	}
	
	@GetMapping("/{UserID}")
	public ResponseEntity<UserDto> getuserByiD(@PathVariable("UserID") Integer UserId){
		UserDto gteUserByID = this.userService.gteUserByID(UserId);
		return ResponseEntity.ok(gteUserByID);
	}
	
	
	
	

}
