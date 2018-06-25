/*
 *  Copyright 2015-2017 zachard, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.zachard.spring.boot.hello;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zachard.spring.boot.hello.model.Book;

/**
 * Spring Boot Hello项目测试基类
 * <pre>
 *     用于配置Spring Boot所需的测试环境
 *     1. {@code SpringBootTest}注解用于指定测试类,用于运行Spring Boot的测试基类
 *     2. {@code SpringBootTest}会自动注册{@code TestRestTemplate}实例到整个Web容器之中
 *     3. {@code WebAppConfiguration}用于声明加载的应用程序上下文是一个Web应用上下文
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloApplication.class)
@WebAppConfiguration
public class HelloApplicationTest {
	
	/**
	 * 通过{@link WebAppConfiguration}得到一个{@link WebApplicationContext}类型的Bean，
	 * 并自动注入
	 */
	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;
	
	/**
	 * 每个测试方法执行之前都需要执行的方法
	 * 
	 * {@link SecurityMockMvcConfigurers#springSecurity()}用于配置Spring Security
	 */
	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(webContext)
				//.apply(SecurityMockMvcConfigurers.springSecurity())
				.build();
	}
	
	/**
	 * 通过{@link MockMvc}对Controller进行测试
	 * 
	 * <pre>
	 *     期望测试结果如下: 
	 *         (1) 请求URL的方式为GET
	 *         (2) 请求URL返回的状态码为200
	 *         (3) Controller返回的视图名称为readingList
	 *         (4) Controller返回的Model中必须包含books属性,且属性必须为空
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void readList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/book/Cary"))
		    .andExpect(MockMvcResultMatchers.status().isOk())
		    .andExpect(MockMvcResultMatchers.view().name("readingList"))
		    .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
		    .andExpect(MockMvcResultMatchers.model().attribute("books", 
		    		Matchers.is(Matchers.empty())));
	}
	
	/**
	 * 通过{@link MockMvc}对Controller的POST方法进行测试
	 * 
	 * <pre>
	 *     测试期望结果如下: 
	 *         (1) 发起一个POST请求,将书籍添加到列表
	 *         (2) 添加书籍成功后,请求会被重定向,并且重定向的URL为: /book/{reader}
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void addToReadingListTest() throws Exception {
		// 通过MockMvc测试POST方法请求
		mockMvc.perform(MockMvcRequestBuilders.post("/book/Cary")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title", "BOOK TITLE")
				.param("author", "BOOK AUTHOR")
				.param("isbn", "1234567890")
				.param("description", "DESCRIPTION"))
		    .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
		    .andExpect(MockMvcResultMatchers.header().string("Location", "/book/Cary"));
		
		// 设置期望的书籍
		Book exceptBook = new Book();
		exceptBook.setTitle("BOOK TITLE");
		exceptBook.setAuthor("BOOK AUTHOR");
		exceptBook.setIsbn("1234567890");
		exceptBook.setReader("Cary");
		exceptBook.setDescription("DESCRIPTION");
		
		/*
		 * 通过获取书籍列表, 并判断是否含有保存的书籍断言是否添加书籍成功
		 * 这中验证方法是不科学的, 因为必须保证这个GET测试请求的接口是已经通过的
		 * 
		 * 注: hasSize方法要求的是与books属性个数完全匹配
		 *     contains方法要求books列表中第一个元素与期望的Bean属性完全匹配
		 */
		mockMvc.perform(MockMvcRequestBuilders.get("/book/Cary"))
		    .andExpect(MockMvcResultMatchers.status().isOk())
		    .andExpect(MockMvcResultMatchers.view().name("readingList"))
		    .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
		    .andExpect(MockMvcResultMatchers.model()
		    		.attribute("books", Matchers.hasSize(1)))
		    .andExpect(MockMvcResultMatchers.model()
		    		.attribute("books", Matchers.contains(Matchers.samePropertyValuesAs(exceptBook))));
	}
	
	@Test
	public void contextLoads() {
		
	}

}
