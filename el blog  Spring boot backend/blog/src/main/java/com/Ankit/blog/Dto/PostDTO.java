package com.Ankit.blog.Dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.Ankit.blog.etities.Category;
import com.Ankit.blog.etities.Comment;
import com.Ankit.blog.etities.User;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {

	private int postID;

	private String title;

	private String content;
	private String ImgName;
	private Date addDate;
	
	private CategoryDTO categoryID;
	
	private UserDto userID;
	
	private Set<CommentDTO> comments=new HashSet<CommentDTO>();

}
