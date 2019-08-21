package com.johnny.johnnyBlog.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johnny.johnnyBlog.entity.FullTestBug;
import com.johnny.johnnyBlog.entity.TestBug;
import com.johnny.johnnyBlog.service.TestService;
import com.johnny.johnnyBlog.utils.BlogResult;

@Controller
@RequestMapping("/test")
public class TestController {
	@Resource
	private TestService service;
	@RequestMapping("/loadproduct.do")
	@ResponseBody
	public BlogResult<List<String>> execute(){
		BlogResult<List<String>> result = service.loadProduct();
		return result;
	}
	@RequestMapping("/loadproject.do")
	@ResponseBody
	public BlogResult<List<String>> execute1(){
		BlogResult<List<String>> result1 = service.loadProject();
		return result1;
	}
	@RequestMapping("/loadbugtype.do")
	@ResponseBody
	public BlogResult<List<String>> execute2(){
		BlogResult<List<String>> result2 = service.loadBugtype();
		return result2;
	}
	@RequestMapping("/loadperson.do")
	@ResponseBody
	public BlogResult<List<String>> execute3(){
		BlogResult<List<String>> result3 = service.loadPerson();
		return result3;
	}
	@RequestMapping("/loadmodule.do")
	@ResponseBody
	public BlogResult<List<String>> execute4(){
		BlogResult<List<String>> result4 = service.loadModule();
		return result4;
	}
	@RequestMapping("/saveBug.do")
	@ResponseBody
	public BlogResult execute5(String product,String module,String project,String version,String person,String deadline,String bugtype,String bugtitle,String contents) {
		//System.out.println("saveBug()");
		//System.out.println(product+","+module+","+project+","+version+","+person+","+deadline+","+bugtype+","+bugtitle+","+contents);
		String t = deadline+" 12:00:00";
		Timestamp ts = Timestamp.valueOf(t);
		TestBug bug = new TestBug();
		bug.setBug_content(contents);
		bug.setBug_title(bugtitle);
		bug.setBugtype_id(bugtype);
		bug.setDeadline(ts);
		bug.setModule_id(module);
		bug.setPerson_id(person);
		bug.setProduct_id(product);
		bug.setProject_id(project);
		bug.setVersion(version);
		//System.out.println(bug);
		service.saveBug(bug);
		BlogResult result = new BlogResult();
		result.setMsg("保存成功");
		result.setStatus(1);
		return result;
	}
	@RequestMapping("/findAllBug.do")
	@ResponseBody
	public BlogResult<List<FullTestBug>> execute6() {
		BlogResult<List<FullTestBug>> result = service.loadFullBug();
		return result;
	}
	@RequestMapping("/findBugById.do")
	@ResponseBody
	public BlogResult<FullTestBug> execute7(String bugId){
		BlogResult<FullTestBug> result = service.findBugById(bugId);
		return result;
	}
	@RequestMapping("/findPartBug.do")
	@ResponseBody
	public BlogResult<List<FullTestBug>> execute8(int pageBegin,int pageSize) {
		BlogResult<List<FullTestBug>> result = service.loadPartBug(pageBegin, pageSize);
		return result;
	}
	@RequestMapping("/findTestBugById.do")
	@ResponseBody
	public BlogResult<TestBug> execute9(String bugId){
		BlogResult<TestBug> result = service.findTestBugById(bugId);
		return result;
	}
	@RequestMapping("/updateBug.do")
	@ResponseBody
	public BlogResult execute10(String bugId,String product,String module,String project,String version,String person,String deadline,String bugtype,String bugtitle,String contents) {
		String t = deadline+" 12:00:00";
		Timestamp ts = Timestamp.valueOf(t);
		TestBug bug = new TestBug();
		bug.setBug_content(contents);
		bug.setBug_title(bugtitle);
		bug.setBugtype_id(bugtype);
		bug.setDeadline(ts);
		bug.setModule_id(module);
		bug.setPerson_id(person);
		bug.setProduct_id(product);
		bug.setProject_id(project);
		bug.setVersion(version);
		bug.setBug_id(bugId);
		//System.out.println(bug);
		service.updateBug(bug);
		BlogResult result = new BlogResult();
		result.setMsg("保存成功");
		result.setStatus(1);
		return result;
	}
	
	
}
