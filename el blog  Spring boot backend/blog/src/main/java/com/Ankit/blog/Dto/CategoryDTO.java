package com.Ankit.blog.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

	private Integer CategoryID;
	private String categoryTitle;

	private String categoryDescription;

}
