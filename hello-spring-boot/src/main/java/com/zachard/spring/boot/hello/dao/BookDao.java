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

package com.zachard.spring.boot.hello.dao;

import java.util.List;

import com.zachard.spring.boot.hello.model.Book;

/**
 * Book的持久化层
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public interface BookDao {
	
	/**
	 * 根据读者查询读者在读书籍列表
	 * 
	 * @param reader    读者姓名
	 * @return          读者在读书籍列表
	 */
	List<Book> findByReader(String reader);
	
	/**
	 * 新增书籍
	 * 
	 * @param book    需要新增的数据
	 */
	void add(Book book);

}
