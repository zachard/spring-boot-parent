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

package com.zachard.spring.boot.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zachard.spring.boot.hello.model.Book;
import com.zachard.spring.boot.hello.service.BookService;

/**
 * {@link Book}相关请求Controller
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Controller
@RequestMapping("/book")
public class BookController {
	
	private BookService bookService;
	
	/**
	 * 查询读者阅读书籍列表请求接口
	 * 
	 * @param reader    读者姓名
	 * @param model     模型对象
	 * @return          读者书籍列表逻辑视图名称
	 */
	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		List<Book> readingList = bookService.findByReader(reader);
		
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}
		
		return "readingList";
	}
	
	/**
	 * 将书籍添加到读者书籍列表
	 * 
	 * @param reader    读者对象
	 * @param book      读者阅读的书籍
	 * @return          新增阅读书籍逻辑视图名称
	 */
	@RequestMapping(value="/{reader}", method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		bookService.add(book);
		return "redirect:/book/{reader}";
	}

	/**
	 * 自动装配{@link Book}对象持久化组件
	 * 
	 * @param  bookRepository  系统自动扫描注解的组件
	 */
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
