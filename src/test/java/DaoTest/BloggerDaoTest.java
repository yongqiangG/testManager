package DaoTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.johnnyBlog.dao.BloggerDao;
import com.johnny.johnnyBlog.dao.TestDao;
import com.johnny.johnnyBlog.entity.Blogger;
import com.johnny.johnnyBlog.entity.FullTestBug;
import com.johnny.johnnyBlog.entity.TestBug;
import com.johnny.johnnyBlog.service.TestService;
import com.johnny.johnnyBlog.utils.BlogResult;

public class BloggerDaoTest {
	String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	@Test
	public void test1() {
		BloggerDao dao = ac.getBean("bloggerDao",BloggerDao.class);
		Blogger blogger = dao.findByUsername("admin");
		System.out.println(blogger);
	}
	@Test
	public void test2() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		List<String> list = dao.findAllProduct();
		List<String> list1 = dao.findAllModule();
		List<String> list2 = dao.findAllProject();
		List<String> list3 = dao.findAllPerson();
		List<String> list4 = dao.findAllBugtype();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
		for(int i=0;i<list3.size();i++) {
			System.out.println(list3.get(i));
		}
		for(int i=0;i<list4.size();i++) {
			System.out.println(list4.get(i));
		}
	}
	@Test
	public void test3() {
		TestService service = ac.getBean("testService",TestService.class);
		BlogResult<List<String>> result = service.loadProduct();
		System.out.println(result);
	}
	@Test
	public void test4() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		TestBug bug = new TestBug();
		bug.setBug_content("hello");
		bug.setBug_title("hello");
		bug.setBugtype_id("1");
		bug.setDeadline(new Timestamp(System.currentTimeMillis()));
		bug.setModule_id("2");
		bug.setPerson_id("3");
		bug.setProduct_id("2");
		bug.setProject_id("1");
		bug.setVersion("1.9.0");
		System.out.println(bug);
		dao.saveBug(bug);
	}
	@Test
	public void test5() {
		TestService service = ac.getBean("testService",TestService.class);
		TestBug bug = new TestBug();
		bug.setBug_content("【步骤】<br />\r\n" + 
				"321<br />\r\n" + 
				"【结果】<br />\r\n" + 
				"<br />\r\n" + 
				"【预期】<br />\r\n" + 
				"<br />");
		bug.setBug_title("123");
		bug.setBugtype_id("3");
		bug.setDeadline(new Timestamp(System.currentTimeMillis()));
		bug.setModule_id("1");
		bug.setPerson_id("4");
		bug.setProduct_id("1");
		bug.setProject_id("1");
		bug.setVersion("1.1.1");
		service.saveBug(bug);
	}
	@Test
	public void test6() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		List<TestBug> list = dao.loadBug();
		for(TestBug bug:list) {
			System.out.println(bug);
		}
	}
	@Test
	//测试loadBug()的Service实现方法
	public void test7() {
		TestService service = ac.getBean("testService",TestService.class);
		BlogResult<List<TestBug>> result = new BlogResult();
		result = service.loadBug();
		System.out.println(result);
	}
	@Test
	//测试loadFullBug的Dao
	public void test8() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		List<FullTestBug> list = dao.loadFullBug();
		for(FullTestBug b:list) {
			System.out.println(b);
		}
	}
	@Test
	//测试findBugById的Dao
	public void test9() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		FullTestBug b = dao.findBugById("39");
		System.out.println(b.getBug_content_withoutHtml());
	}
	@Test
	//测试findBugById的Service方法
	public void test10() {
		TestService service = ac.getBean("testService",TestService.class);
		BlogResult<FullTestBug> result = service.findBugById("3");
		System.out.println(result);
	}
	@Test
	//测试分页方法
	public void test11() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		Map<String,Integer> pageMsg = new HashMap();
		pageMsg.put("pageBegin", 0);
		pageMsg.put("pageSize", 10);
		List<FullTestBug> list = dao.loadPartBug(pageMsg);
		for(FullTestBug b:list) {
			System.out.println(b);
		}
	}
	@Test
	//findTestBugById
	public void test12() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		TestBug bug = dao.findTestBugById("23");
		System.out.println(bug);
	}
	@Test
	//updateBugById
	public void test13() {
		TestDao dao = ac.getBean("testDao",TestDao.class);
		TestBug bug = new TestBug();
		bug.setBug_content("【步骤】<br />\r\n" + 
				"321<br />\r\n" + 
				"【结果】<br />\r\n" + 
				"<br />\r\n" + 
				"【预期】<br />\r\n" + 
				"<br />");
		bug.setBug_title("测试update()");
		bug.setBugtype_id("3");
		bug.setDeadline(new Timestamp(System.currentTimeMillis()));
		bug.setModule_id("1");
		bug.setPerson_id("4");
		bug.setProduct_id("1");
		bug.setProject_id("1");
		bug.setVersion("1.1.1");
		bug.setBug_id("20");
		dao.updateBugById(bug);
	}
	@Test
	//update方法的Service
	public void test14() {
		TestService service = ac.getBean("testService",TestService.class);
		TestBug bug = new TestBug();
		bug.setBug_content("【步骤】<br />\r\n" + 
				"321<br />\r\n" + 
				"【结果】<br />\r\n" + 
				"<br />\r\n" + 
				"【预期】<br />\r\n" + 
				"<br />");
		bug.setBug_title("ceshi");
		bug.setBugtype_id("3");
		bug.setDeadline(new Timestamp(System.currentTimeMillis()));
		bug.setModule_id("1");
		bug.setPerson_id("4");
		bug.setProduct_id("1");
		bug.setProject_id("1");
		bug.setVersion("1.1.1");
		bug.setBug_id("20");
		service.updateBug(bug);
	}
	
}
