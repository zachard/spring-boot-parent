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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot 框架学习 Hello World 示例
 * <p>
 *  {@link RestController} 注解表示控制器支持REST
 *  {@link EnableAutoConfiguration} 注解告诉Spring Boot如何配置Spring
 * </p>
 *
 * @author zachard
 * @version 1.0.0
 */
@RestController
@EnableAutoConfiguration
public class HelloSpringBoot {
	
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
	
	public static void main(String[] args) throws Exception {
		
		/* 通过SpringApplication类启动一个Spring应用
		 * run方法中第一个参数声明Spring的组件，第二个参数传递所有命令行参数
		 */
		SpringApplication.run(HelloSpringBoot.class, args);
	}

}
