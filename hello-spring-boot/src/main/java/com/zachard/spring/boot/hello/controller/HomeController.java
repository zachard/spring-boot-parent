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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zachard.spring.boot.hello.bean.PropertySourceBean;

/**
 * <p>
 *  {@link RestController} 注解表示控制器支持REST
 * </p>
 *
 * @author zachard
 * @version 1.0.0
 */
@RestController
public class HomeController {
	
	@Autowired
	private PropertySourceBean propertySourceBean;
	
	/**
	 * 对 / 请求进行处理的控制器
	 * <p>
	 *   <{@link RequestMapping} 注解定义了请求路径与方法的映射
	 * </p>
	 * 
	 * @return   控制器返回内容
	 */
	@RequestMapping("/")
	String home() {
		return "Hello World";
	}
	
	/**
	 * 对 /property 请求进行处理
	 * 
	 * @return   控制器返回内容
	 */
	@RequestMapping("/property")
	String property() {
		return propertySourceBean.getName() + " " + propertySourceBean.getAge();
	}
	
	/**
	 * 对 ／servers 请求进行处理
	 * 
	 * @return   控制器返回的内容
	 */
	@RequestMapping("/servers")
	String servers() {
		StringBuilder serversBuilder = new StringBuilder();
		List<String> servers = propertySourceBean.getServers();
		servers.forEach(server -> serversBuilder.append(server + " "));
		
		return serversBuilder.toString();
	}

	/**
	 * 获取 propertySourceBean 属性对象
	 * @return {@link PropertySourceBean}  对象
	 */
	public PropertySourceBean getPropertySourceBean() {
		return propertySourceBean;
	}

	/**
	 * 设置 propertySourceBean 属性对象
	 * @param propertySourceBean 需要设置的属性对象
	 */
	public void setPropertySourceBean(PropertySourceBean propertySourceBean) {
		this.propertySourceBean = propertySourceBean;
	}

}
