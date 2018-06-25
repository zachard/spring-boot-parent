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

package com.zachard.spring.boot.hello.service;

import java.util.List;

import com.zachard.spring.boot.hello.model.Book;

/**
 * 书籍相关的Service接口
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public interface BookService {
	
	/**
	 * 根据读者查询其阅读的数据列表
	 * 
	 * @param reader    读者名称
	 * @return          读者在读的书籍列表
	 */
	List<Book> findByReader(String reader);
	
	/**
	 * 新增书籍
	 * 
	 * @param book
	 */
	void add(Book book);

}
