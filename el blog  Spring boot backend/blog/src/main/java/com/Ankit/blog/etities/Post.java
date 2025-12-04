package com.Ankit.blog.etities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postID;
	
	private String title;
	@Column(length = 10000)
	private String content;
	private String ImgName;
	private Date addDate;
	
	@ManyToOne
	@JoinColumn(name="categoryID")
	private Category categoryID;
	@ManyToOne
	private User userID;
	@OneToMany(mappedBy = "postID",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comments= new HashSet<Comment>();
	
	
	
	
	

}
