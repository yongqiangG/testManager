package com.johnny.johnnyBlog.service;

import java.util.List;
import java.util.Map;

import com.johnny.johnnyBlog.entity.FullTestBug;
import com.johnny.johnnyBlog.entity.TestBug;
import com.johnny.johnnyBlog.utils.BlogResult;

public interface TestService {
	public BlogResult<List<String>> loadProduct();
	public BlogResult<List<String>> loadProject();
	public BlogResult<List<String>> loadBugtype();
	public BlogResult<List<String>> loadPerson();
	public BlogResult<List<String>> loadModule();
	public void saveBug(TestBug bug);
	public BlogResult<List<TestBug>> loadBug();
	public BlogResult<List<FullTestBug>> loadFullBug();
	public BlogResult<FullTestBug> findBugById(String bugId);
	public BlogResult<List<FullTestBug>> loadPartBug(int pageBegin,int pageSize);
	public BlogResult<TestBug> findTestBugById(String bugId);
	public void updateBug(TestBug bug);
	public FullTestBug getPdf(String bugId);
}
