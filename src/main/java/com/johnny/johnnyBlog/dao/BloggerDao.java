package com.johnny.johnnyBlog.dao;

import com.johnny.johnnyBlog.entity.Blogger;

public interface BloggerDao {
	public Blogger findByUsername(String username);
}
