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

package com.zachard.spring.boot.hello.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Spring Boot的PropertySource属性值覆盖测试
 * <p>
 *   {@link Component} 注解表明一个注解类为组件,在扫描包时，会被自动发现
 *   {@link ConfigurationProperties} 注解将yaml文件中属性注入到类的同名属性中
 * </p>
 *
 * @author zachard
 * @version 1.0.0
 */
@Component
//@ConfigurationProperties(prefix="my")
public class PropertySourceBean {
	
	/**
	 * {@link Value} 用于注解属性、方法/构造器的参数，表示被注解参数的默认的值表达式
	 * <p>
	 *    使用{@value}注解，必须在配置文件中或是程序启动时设置name属性值,否则程序无法启动
	 * </p>
	 */
	@Value("${name}")
	//@Value("${random.value}")
	//@Value("${my.name}")
	private String name;
	
	/**
	 * SpringBoot生成随机数并设置到Bean属性示例
	 * <p>
	 *   通过random随机生成相应数值，而random.value值可以随机生成字符串
	 * </p>
	 */
	//@Value("${random.int}")
	//@Value("${random.long}")  //生成随机大整数
	//@Value("${random.int(10)}")    //生成小于10的随机整数
	@Value("${random.int[1024,65536]}")  //生成指定范围的随机整数
	private int age;
	
	/**
	 * Spring Boot YAML文件中配置属性并设置到Bean属性示例 {@value} 注解方式
	 * <p>
	 *     对于需要注入yaml文件中的数组属性时，
	 *     <pre>
	 *     my: 
	 *       servers: 
	 *         - dev.zachard.com
	 *         - foo.zachard.com
	 *     </pre>
	 *     类型的配置是无效的，解析时解析为数组对象，而不是List对象，正确的配置如下:
	 *     <pre>
	 *     my: 
	 *       servers: dev.zachard.com,foo.zachard.com
	 *     </pre>
	 *     并且在{@value}注解中配置的占位符也与其他属性不一致
	 * </p>
	 */
	@Value("#{'${my.servers}'.split(',')}")
	private List<String> servers = new ArrayList<>();

	/**
	 * 获取 name 属性的方式
	 * @return name 属性
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 name 属性的方式
	 * @param name 需要设置的name属性
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取age属性值
	 * @return age的值
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 设置age属性的值
	 * @param age 设置age属性的值
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 获取servers属性的值
	 * @return servers的值
	 */
	public List<String> getServers() {
		return servers;
	}

	/**
	 * 设置servers的值
	 * @param servers 需要设置的servers参数
	 */
	public void setServers(List<String> servers) {
		this.servers = servers;
	}

}
