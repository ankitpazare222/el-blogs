package com.Ankit.blog.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int ID;
	
	@NotNull
	private String name;
	@Email
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String About;

}
