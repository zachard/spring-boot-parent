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

package com.zachard.spring.boot.hello.model;

/**
 * 书籍实体类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class Book {
	
	private Long id;
	private String reader;
	private String isbn;
	private String title;
	private String author;
	private String description;
	
	/**
	 * 当添加了其他构造器时,一定要记得声明初始化构造器
	 */
	public Book() {
		
	}
	
	/**
	 * 作为初始化数据的构造器, 将数据库及持久化层去除(方便构造数据)
	 * 
	 * @param id
	 * @param reader
	 * @param isbn
	 * @param title
	 * @param author
	 * @param description
	 */
	public Book(Long id, String reader, String isbn, String title, String author, String description) {
		super();
		this.id = id;
		this.reader = reader;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the reader
	 */
	public String getReader() {
		return reader;
	}
	/**
	 * @param reader the reader to set
	 */
	public void setReader(String reader) {
		this.reader = reader;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
