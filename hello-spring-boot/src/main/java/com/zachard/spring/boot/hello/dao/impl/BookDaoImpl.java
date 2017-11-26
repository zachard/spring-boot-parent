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

package com.zachard.spring.boot.hello.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.zachard.spring.boot.hello.dao.BookDao;
import com.zachard.spring.boot.hello.model.Book;

/**
 * 书籍持久化层实现类
 * 
 * <pre>
 *     在学习示例代码时,将数据库去除, 所有数据在DAO层定义, 项目初始化之后加载到内存
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Component
public class BookDaoImpl implements BookDao {
	
	/**
	 * 模拟数据库书籍表中的初始化数据
	 */
	private static List<Book> initBooks = new ArrayList<>();
	
	/**
	 * 作用: 模拟数据库初始化数据
	 */
	static {
		initBooks.add(new Book(1L, "Amy", "1111", "1111", "凌大", "1111"));
		initBooks.add(new Book(2L, "Amy", "2222", "2222", "唐二", "2222"));
		initBooks.add(new Book(3L, "Bob", "3333", "3333", "张三", "3333"));
		initBooks.add(new Book(3L, "Cary", "4444", "4444", "李四", "4444"));
	}
	
	/**
	 * 根据读者查询读者在读书籍列表
	 * 
	 * @param reader    读者姓名
	 * @return          读者在读书籍列表
	 */
	@Override
	public List<Book> findByReader(String reader) {
		return initBooks.stream()
		         .filter(book -> Objects.equals(book.getReader(), reader))
		         .collect(Collectors.toList());
	}
	
	/**
	 * 新增书籍
	 * 
	 * @param book    需要新增的数据
	 */
	@Override
	public void add(Book book) {
		initBooks.add(book);
	}

}
