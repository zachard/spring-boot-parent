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

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zachard.spring.boot.hello.model.Customer;
import com.zachard.spring.boot.hello.model.User;

/**
 * Spring Boot Restful Controller接口示例
 * <pre>
 *   {@link RestController}注解为{@link Controller}与{@link ResponseBody}的组合注解
 *   {@link Controller}注解表明被注释的类为一个Controller控制器
 *   {@link ResponseBody}注解表明一个方法的返回值必须是一个web的响应体
 *   {@link RequestMapping}注解表明将一个web请求映射到指定的处理类获取处理方法上
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@RestController
@RequestMapping(value="/users")
public class UserController {
	
	/**
	 * 根据传入的用户的ID值获取指定的用户对象
	 * <pre>
	 *   {@link RequestMapping}注解中value表示映射表达式, method表示HTTP请求的方法
	 *   {@link PathVariable}注解表明方法的参数与URI模版的值绑定,在Servlet环境中，支持{@link RequestMapping}注解
	 * </pre>
	 * @param user  用户ID
	 * @return      用户信息
	 */
	@RequestMapping(value="/{user}", method=RequestMethod.GET)
	public User getUser(@PathVariable Long user) {
		return new User();
	}

	/**
	 * 根据用户ID获取用户下的Customer对象
	 * 
	 * @param user  用户ID
	 * @return      用户相关联的Customer对象
	 */
	@RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
	List<Customer> getUserCustomers(@PathVariable Long user) {
		return new ArrayList<>();
	}
	
	/**
	 * 根据用户ID删除用户
	 * 
	 * @param user  用户ID
	 * @return      被删除的用户信息
	 */
	@RequestMapping(value="/{user}", method=RequestMethod.DELETE)
	public User deleteUser(@PathVariable Long user) {
		return new User();
	}
	
}
