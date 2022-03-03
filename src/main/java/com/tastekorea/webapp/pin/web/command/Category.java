package com.tastekorea.webapp.pin.web.command;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author "rohyh"
 *
 */
@Getter
@Setter
public class Category {
	private long categoryId;
	private String category;
	
	public Category(long categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}

	public Category(long categoryId) {
		super();
		this.categoryId = categoryId;
	}
}
