package com.johnny.johnnyBlog.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.johnny.johnnyBlog.dao.BloggerDao;
import com.johnny.johnnyBlog.entity.Blogger;
import com.johnny.johnnyBlog.service.BloggerService;
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	@Resource
	private BloggerDao bloggerDao;

	public Blogger getByUsername(String username) {
		return bloggerDao.findByUsername(username);
	}

}
