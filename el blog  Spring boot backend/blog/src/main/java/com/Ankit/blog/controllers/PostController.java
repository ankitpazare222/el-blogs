package com.Ankit.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.blog.Dto.PostDTO;
import com.Ankit.blog.Dto.PostResponse;
import com.Ankit.blog.services.PostService;

@RestController
@RequestMapping("/api/Post")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/{UserID}/{cateID}")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto, @PathVariable("UserID") Integer UserID,
			@PathVariable("cateID") Integer cateID) {
		PostDTO post = this.postService.createPost(postDto, UserID, cateID);
		return new ResponseEntity<PostDTO>(post, HttpStatus.CREATED);

	}

	@GetMapping("/cateID/{catID}")
	public ResponseEntity<List<PostDTO>> getallPostBycategory(@PathVariable("catID") Integer cateID) {
		List<PostDTO> getallPostBycategory = this.postService.getallPostBycategory(cateID);
		return  ResponseEntity.ok(getallPostBycategory);

	}
	@GetMapping("/UserID/{UserID}")
	public ResponseEntity<List<PostDTO>>  getallPostbyUser(@PathVariable("UserID")Integer UserID){
		List<PostDTO> getallPostbyUser = this.postService.getallPostbyUser(UserID);
		return  ResponseEntity.ok(getallPostbyUser);
	}
	
	@GetMapping("/allPost")
	public ResponseEntity<PostResponse> getallPost(
			
			@RequestParam(value = "pageNumber" ,defaultValue = "0",required = false) Integer pageNumber ,
			@RequestParam(value = "pageSize" ,defaultValue = "3",required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = "postID",required = false) String Sortby
			
			){
		 PostResponse getallPost = this.postService.getallPost(pageNumber, pageSize,Sortby);
		return ResponseEntity.ok(getallPost);
	}
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletepost(@PathVariable("postId") Integer postID){
		this.postService.deletepost(postID);
		return new ResponseEntity(Map.of("meaasage","post deleted sucessfully"),HttpStatus.OK);
		
	}
	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> getPostByiD(@PathVariable("postId") Integer postID){
		PostDTO postByiD = this.postService.getPostByiD(postID);
		return ResponseEntity.ok(postByiD);
	}
	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDto,@PathVariable("postId") Integer postID){
		PostDTO updatePost = this.postService.updatePost(postDto, postID);
		return ResponseEntity.ok(updatePost);
	}
	
	@GetMapping("/search/{search}")
	public ResponseEntity<List<PostDTO>> SearchPosts(@PathVariable("search") String keywords){
		
		List<PostDTO> searchPosts = this.postService.SearchPosts(keywords);
		
		return ResponseEntity.ok(searchPosts);
	
}

}
