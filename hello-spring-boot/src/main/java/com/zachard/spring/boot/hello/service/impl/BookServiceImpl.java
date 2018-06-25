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

package com.zachard.spring.boot.hello.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zachard.spring.boot.hello.dao.BookDao;
import com.zachard.spring.boot.hello.model.Book;
import com.zachard.spring.boot.hello.service.BookService;

/**
 * 书籍相关Service层实现类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Resource
	private BookDao bookDao;
	
	/**
	 * 根据读者查询其阅读的数据列表
	 * 
	 * @param reader    读者名称
	 * @return          读者在读的书籍列表
	 */
	@Override
	public List<Book> findByReader(String reader) {
		return bookDao.findByReader(reader);
	}
	
	/**
	 * 新增书籍
	 * 
	 * @param book
	 */
	@Override
	public void add(Book book) {
		bookDao.add(book);
	}

}
