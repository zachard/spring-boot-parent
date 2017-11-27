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

import org.springframework.stereotype.Component;

import com.zachard.spring.boot.hello.dao.ReaderDao;
import com.zachard.spring.boot.hello.model.Reader;

/**
 * 读者持久化层实现类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Component
public class ReaderDaoImpl implements ReaderDao {
	
	private static List<Reader> initReaders = new ArrayList<>();
	
	/**
	 * 初始化读者数据
	 */
	static {
		initReaders.add(new Reader("Amy", "Amy Paul", "123456"));
		initReaders.add(new Reader("Bob", "Bob Paul", "123456"));
		initReaders.add(new Reader("Cary", "Cary Paul", "123456"));
	}
	
	/**
	 * 根据用户查找读者
	 * 
	 * @param username    读者用户名
	 * @return            读者信息
	 */
	@Override
	public Reader findByUsername(String username) {
		return initReaders.stream()
				          .filter(reader -> Objects.equals(reader.getUsername(), username))
				          .findFirst().get();
	}

}
