package com.Ankit.blog.etities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String name;
	private String email;
	private String password;
	private String About;
	
	@OneToMany(mappedBy = "userID",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts=new ArrayList<Post>();
//	private String name;
	
	@OneToMany(mappedBy = "userID",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comments=new HashSet<Comment>();
	
	

}
