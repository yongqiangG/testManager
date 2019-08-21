package com.johnny.johnnyBlog.service;

import com.johnny.johnnyBlog.entity.Blogger;

public interface BloggerService {
	public Blogger getByUsername(String username); 
}
