package com.Ankit.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.blog.Dto.CommentDTO;
import com.Ankit.blog.etities.Comment;
import com.Ankit.blog.etities.Post;
import com.Ankit.blog.exceptions.ResourceNotFundException;
import com.Ankit.blog.repo.CommentRepo;
import com.Ankit.blog.repo.PostRepo;
import com.Ankit.blog.services.CommentService;
@Service
public class CommentImpl implements CommentService{
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CommentDTO create(CommentDTO commentDTO, Integer postID) {
		// TODO Auto-generated method stubth
		
		Post postiD= this.postRepo.findById(postID).orElseThrow(()-> new ResourceNotFundException("post", "iD", postID));
		Comment map = this.modelmapper.map(commentDTO, Comment.class);
		map.setPostID(postiD);
		Comment save = this.commentRepo.save(map);
		return this.modelmapper.map(save, CommentDTO.class);
	}

	@Override
	public void deleteCMTbyuD(Integer CMTid) {
		Comment cmtiD = this.commentRepo.findById(CMTid).orElseThrow(()-> new ResourceNotFundException("cmt", "iD", CMTid));
		this.commentRepo.deleteById(CMTid);
		// TODO Auto-generated method stub
		
	}

}
