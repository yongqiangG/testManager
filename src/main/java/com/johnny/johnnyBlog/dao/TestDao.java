package com.johnny.johnnyBlog.dao;

import java.util.List;
import java.util.Map;

import com.johnny.johnnyBlog.entity.FullTestBug;
import com.johnny.johnnyBlog.entity.TestBug;

public interface TestDao {
	//查询bug信息
	public List<String>  findAllProduct();
	public List<String>  findAllModule();
	public List<String>  findAllProject();
	public List<String>  findAllBugtype();
	public List<String>  findAllPerson();
	//提交bug
	public void saveBug(TestBug testBug);
	//查询所有bug
	public List<TestBug> loadBug();
	//查询带外键名字的bug
	public List<FullTestBug> loadFullBug();
	//查询带外键名字的bug
	public FullTestBug findBugById(String bugId);
	//分页查询bug
	public List<FullTestBug> loadPartBug(Map pageMsg);
	//更新bug
	public void updateBugById(TestBug testBug);
	//获取带名字的bug
	public TestBug findTestBugById(String bugId);
}
