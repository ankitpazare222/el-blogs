package com.Ankit.blog.services;

import com.Ankit.blog.Dto.CommentDTO;

public interface CommentService {

	CommentDTO create(CommentDTO commentDTO, Integer postID);
	
	void deleteCMTbyuD(Integer CMTid);
}
