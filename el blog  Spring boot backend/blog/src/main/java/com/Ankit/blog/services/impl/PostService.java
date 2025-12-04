package com.Ankit.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Ankit.blog.Dto.CategoryDTO;
import com.Ankit.blog.Dto.PostDTO;
import com.Ankit.blog.Dto.PostResponse;
import com.Ankit.blog.etities.Category;
import com.Ankit.blog.etities.Post;
import com.Ankit.blog.etities.User;
import com.Ankit.blog.exceptions.ResourceNotFundException;
import com.Ankit.blog.repo.CategoryRepo;
import com.Ankit.blog.repo.PostRepo;
import com.Ankit.blog.repo.UserRepo;
@Service
public class PostService implements com.Ankit.blog.services.PostService {

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private PostRepo postrepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private CategoryRepo category;
	
	@Override
	public PostDTO createPost(PostDTO postDto,Integer UserID,Integer cateID) {
		
		User User = this.userrepo.findById(UserID).orElseThrow(()->  new ResourceNotFundException("User", "UserID", UserID));
		Category Cat = this.category.findById(cateID).orElseThrow(()->  new ResourceNotFundException("category", "CategoryID", cateID));
		Post map = this.modelmapper.map(postDto, Post.class);
		map.setUserID(User);
		map.setCategoryID(Cat);
		map.setAddDate(new Date());
		// TODO Auto-generated method stub
		Post save = this.postrepo.save(map);
		return this.modelmapper.map(save, PostDTO.class);
	}

	@Override
	public PostDTO updatePost(PostDTO postDto, Integer postID) {
		
		Post updatedPost = this.postrepo.findById(postID).orElseThrow(()-> new ResourceNotFundException("Post", "ID", postID));
		// TODO Auto-generated method stub
		updatedPost.setAddDate(postDto.getAddDate());
		updatedPost.setContent(postDto.getContent());
		updatedPost.setImgName(postDto.getImgName());
		updatedPost.setTitle(postDto.getTitle());
		Post update = this.postrepo.save(updatedPost);
		return this.modelmapper.map(update, PostDTO.class);
	}

	@Override
	public PostDTO getPostByiD(Integer postID) {
		
		Post getByID = this.postrepo.findById(postID).orElseThrow(()-> new ResourceNotFundException("Post", "ID", postID));
		// TODO Auto-generated method stub
	
		return this.modelmapper.map(getByID, PostDTO.class);
	}

	@Override
	public void deletepost(Integer postID) {
		
		Post getByID = this.postrepo.findById(postID).orElseThrow(()-> new ResourceNotFundException("Post", "ID", postID));
		
		this.postrepo.deleteById(postID);
		
		
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public PostResponse getallPost(Integer pageNumber,Integer pageSize,String Sortby) {
		
		Pageable p=PageRequest.of(pageNumber, pageSize, Sort.by(Sortby).descending());
		Page<Post> pageOfpost = this.postrepo.findAll(p);
		List<Post> content = pageOfpost.getContent();
		List<PostDTO> all=	content	.stream().map((Post) -> this.modelmapper.map(Post,PostDTO.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(all);
		postResponse.setPageNumber(pageOfpost.getNumber());
		postResponse.setPageSize(pageOfpost.getSize());
		postResponse.setTotalElement(pageOfpost.getTotalElements());
		postResponse.setLastPage(pageOfpost.isLast());
		// TODO Auto-generated method stub
		return postResponse;
	}

	@Override
	public List<PostDTO> getallPostBycategory(Integer cateID) {
		
		Category Cat = this.category.findById(cateID).orElseThrow(()->  new ResourceNotFundException("category", "CategoryID", cateID));
		
		List<Post> byCategoryID = this.postrepo.findByCategoryID(Cat);
		
		List<PostDTO> collectcatID = byCategoryID.stream().map((post) -> this.modelmapper.map(post, PostDTO.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return collectcatID;
	}

	@Override
	public List<PostDTO> getallPostbyUser(Integer UserID) {
		User User = this.userrepo.findById(UserID).orElseThrow(()->  new ResourceNotFundException("User", "UserID", UserID));
		List<Post> byUserID = this.postrepo.findByUserID(User);
		List<PostDTO> collect = byUserID.stream().map((user)-> this.modelmapper.map(user, PostDTO.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return collect;
	}

	@Override
	public List<PostDTO> SearchPosts(String keywords) {
		List<Post> byTitleContaining = this.postrepo.findByTitleContaining(keywords);
		List<PostDTO> collect = byTitleContaining.stream().map((post)-> this.modelmapper.map(post,PostDTO.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return collect;
	}

}
