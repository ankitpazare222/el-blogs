package com.Ankit.blog.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.blog.Dto.CommentDTO;
import com.Ankit.blog.services.CommentService;
@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentservice;
	
	@PostMapping("/{postID}")
	public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO commentDTO,@PathVariable("postID") Integer postID){
		CommentDTO commentsave = this.commentservice.create(commentDTO, postID);
		return  ResponseEntity.ok(commentsave);
	}
	@DeleteMapping("/{cmtID}")
	public ResponseEntity<?>deleteCMTbyuD(@PathVariable("cmtID") Integer CMTid){
		this.commentservice.deleteCMTbyuD(CMTid);
		return new ResponseEntity(Map.of("meaasage","comment deleted sucessfully"),HttpStatus.OK);
	}

}
