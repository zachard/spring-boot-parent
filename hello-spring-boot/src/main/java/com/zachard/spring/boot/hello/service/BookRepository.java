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

import org.springframework.data.jpa.repository.JpaRepository;

import com.zachard.spring.boot.hello.model.Book;

/**
 * {@link Book}持久化操作接口
 * <pre>
 *     {@link JpaRepository}泛型接口有两个参数: 
 *     一个是仓库操作的领域对象类型, 另一个是领域对象的ID属性类型
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public interface BookRepository extends JpaRepository<Book, Long>{
	
	/**
	 * 获取读者所读书籍列表
	 * 
	 * @param reader    读者
	 * @return          书籍列表
	 */
	List<Book> findByReader(String reader);

}
