package com.example.demo;

import com.example.demo.basemodel.User;
import com.example.demo.server.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Junit5测试类")
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Value("${datasource.password}")
	String dbpwd;
	@Autowired
	private UserService userSerivce;

	@Test
	public void test() throws Exception {
		userSerivce.deleteAllUsers();

		// 插入5个用户
		userSerivce.create("Tom", 10);
		userSerivce.create("Mike", 11);
		userSerivce.create("Didispace", 30);
		userSerivce.create("Oscar", 21);
		userSerivce.create("Linda", 17);

		// 查询名为Oscar的用户，判断年龄是否匹配
		List<User> userList = userSerivce.getByName("Oscar");
		Assertions.assertEquals(21, userList.get(0).getAge().intValue());

		// 查数据库，应该有5个用户
		Assertions.assertEquals(5, userSerivce.getAllUsers());

		// 删除两个用户
		userSerivce.deleteByName("Tom");
		userSerivce.deleteByName("Mike");

		// 查数据库，应该有5个用户
		Assertions.assertEquals(3, userSerivce.getAllUsers());
	}
	@BeforeAll
	public static void ball(){
		System.out.println("启动测试！");
	}
	@AfterAll
	public static void aall(){
		System.out.println("测试结束！");
	}
	@BeforeEach
	public void wri(){
		System.out.println("每次执行前打印...");
	}
	@AfterEach
	public void af(){
		System.out.println("每次执行完毕打印...");
	}

	@DisplayName("测试Controller层")
	@Test
	public void getHello() throws Exception {
		this.mockMvc.perform(get("/hello"))
				.andDo(print())
				.andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello World")))
		;
	}

	@DisplayName("测试assert")
	@RepeatedTest(5)
//	@Test
	public void test1(){
		System.out.println("测试assert");
		System.out.println(jdbcTemplate);
		Assert.hasText("abc","a");
	}
	@Test
	public void testJasypt(){
		System.out.println(dbpwd);
	}
}
