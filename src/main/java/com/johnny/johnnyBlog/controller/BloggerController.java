package com.johnny.johnnyBlog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnny.johnnyBlog.service.BloggerService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	@Resource
	private BloggerService bloggerService;
	//@requestMapping("/login")
	//public 
}
