package com.johnny.johnnyBlog.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.johnny.johnnyBlog.dao.TestDao;
import com.johnny.johnnyBlog.entity.FullTestBug;
import com.johnny.johnnyBlog.entity.TestBug;
import com.johnny.johnnyBlog.service.TestService;
import com.johnny.johnnyBlog.utils.BlogResult;
@Service("testService")
public class TestServiceImpl implements TestService {
	@Resource
	private TestDao dao;
	public BlogResult<List<String>> loadProduct() {
		List<String> list = dao.findAllProduct();
		BlogResult<List<String>> result = new BlogResult<List<String>>();
		if(list==null) {
			result.setStatus(0);
			result.setMsg("找不到产品数据");
			return result;
		} else {
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(list);
			return result;
		}
		
	}
	public BlogResult<List<String>> loadProject() {
		List<String> list = dao.findAllProject();
		BlogResult<List<String>> result1 = new BlogResult<List<String>>();
		if(list==null) {
			result1.setStatus(0);
			result1.setMsg("找不到产品数据");
			return result1;
		} else {
			result1.setStatus(1);
			result1.setMsg("查询成功");
			result1.setData(list);
			return result1;
		}
	}
	public BlogResult<List<String>> loadBugtype() {
		List<String> list = dao.findAllBugtype();
		BlogResult<List<String>> result2 = new BlogResult<List<String>>();
		if(list==null) {
			result2.setStatus(0);
			result2.setMsg("找不到产品数据");
			return result2;
		} else {
			result2.setStatus(1);
			result2.setMsg("查询成功");
			result2.setData(list);
			return result2;
		}
	}
	public BlogResult<List<String>> loadPerson() {
		List<String> list = dao.findAllPerson();
		BlogResult<List<String>> result3 = new BlogResult<List<String>>();
		if(list==null) {
			result3.setStatus(0);
			result3.setMsg("找不到产品数据");
			return result3;
		} else {
			result3.setStatus(1);
			result3.setMsg("查询成功");
			result3.setData(list);
			return result3;
		}
	}
	public BlogResult<List<String>> loadModule() {
		List<String> list = dao.findAllModule();
		BlogResult<List<String>> result4 = new BlogResult<List<String>>();
		if(list==null) {
			result4.setStatus(0);
			result4.setMsg("找不到产品数据");
			return result4;
		} else {
			result4.setStatus(1);
			result4.setMsg("查询成功");
			result4.setData(list);
			return result4;
		}
	}
	public void saveBug(TestBug bug) {
		dao.saveBug(bug);
	}
	public BlogResult<List<TestBug>> loadBug() {
		List<TestBug> bugs = dao.loadBug();
		BlogResult<List<TestBug>> result = new BlogResult();
		if(bugs==null) {
			result.setStatus(0);
			result.setMsg("查不到bug");
			return result;
		} else {
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(bugs);
			return result;
		}
	}
	public BlogResult<List<FullTestBug>> loadFullBug() {
		List<FullTestBug> bugs = dao.loadFullBug();
		BlogResult<List<FullTestBug>> result = new BlogResult();
		if(bugs==null) {
			result.setStatus(0);
			result.setMsg("查不到bug");
			return result;
		} else {
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(bugs);
			return result;
		}
	}
	public BlogResult<FullTestBug> findBugById(String bugId) {
		FullTestBug bug = dao.findBugById(bugId);
		BlogResult<FullTestBug> result = new BlogResult();
		if(bug==null) {
			result.setStatus(0);
			result.setMsg("查不到bug");
			return result;
		} else {
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(bug);
			return result;
		}
	}
	public BlogResult<List<FullTestBug>> loadPartBug(int pageBegin,int pageSize) {
		BlogResult<List<FullTestBug>> result = new BlogResult();
		int begin = (pageBegin-1)*pageSize;
		Map<String,Integer> pageMsg = new HashMap();
		pageMsg.put("pageBegin", begin);
		pageMsg.put("pageSize", pageSize);
		List<FullTestBug> list = dao.loadPartBug(pageMsg);
		if(list.size()==0) {
			result.setStatus(0);
			result.setMsg("查不到任何数据");
			return result;
		}
		result.setStatus(1);
		result.setMsg("查询成功");
		result.setData(list);
		return result;
	}
	public BlogResult<TestBug> findTestBugById(String bugId) {
		TestBug bug = dao.findTestBugById(bugId);
		BlogResult<TestBug> result = new BlogResult();
		if(bug==null) {
			result.setStatus(0);
			result.setMsg("查不到bug");
			return result;
		} else {
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(bug);
			return result;
		}
	}
	public void updateBug(TestBug bug) {
		dao.updateBugById(bug);
	}
	

}
