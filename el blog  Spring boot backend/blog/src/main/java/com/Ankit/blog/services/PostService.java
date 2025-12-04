package com.Ankit.blog.services;

import java.util.List;

import com.Ankit.blog.Dto.PostDTO;
import com.Ankit.blog.Dto.PostResponse;

public interface PostService {
	
	PostDTO createPost(PostDTO postDto ,Integer UserID,Integer cateID);
	
	PostDTO updatePost(PostDTO postDto, Integer postID);
	
	PostDTO getPostByiD(Integer postID);
	
	void deletepost(Integer postID);
	
	PostResponse getallPost(Integer pageNumber,Integer pageSize,String Sortby);
	List<PostDTO> getallPostBycategory(Integer cateID);
	List<PostDTO> getallPostbyUser(Integer UserID);
	
	List<PostDTO> SearchPosts(String keywords);
	
	
	
	

}
