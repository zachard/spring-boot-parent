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

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zachard.spring.boot.hello.dao.ReaderDao;
import com.zachard.spring.boot.hello.model.Reader;
import com.zachard.spring.boot.hello.service.ReaderService;

/**
 * Reader相关Service实现类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Service
public class ReaderServiceImpl implements ReaderService {
	
	@Resource
	private ReaderDao readerDao;
	
	/**
	 * 根据用户查找读者
	 * 
	 * @param username    读者用户名
	 * @return            读者信息
	 */
	@Override
	public Reader findByUsername(String username) {
		Reader reader = readerDao.findByUsername(username);
		
		if (Objects.isNull(reader)) {
			throw new IllegalArgumentException("用户名为: " + username + "的用户不存在");
		}
		
		return reader;
	}

}
