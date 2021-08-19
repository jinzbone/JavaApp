package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

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
				.andExpect(content().string(containsString("Hello World")));
	}

	@DisplayName("测试assert")
	@RepeatedTest(5)
//	@Test
	public void test(){
		System.out.println("测试assert");
		System.out.println(jdbcTemplate);
		Assert.hasText("abc","a");
	}

}
