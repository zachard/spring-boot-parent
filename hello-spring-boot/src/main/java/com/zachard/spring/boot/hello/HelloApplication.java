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

package com.zachard.spring.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring Boot 框架学习 Hello World 示例
 * <p>
 *   {@link EnableAutoConfiguration} 注解告诉Spring Boot如何配置Spring
 *   {@link ComponentScan} 注解告诉Spring Boot将注解的类自动扫描为Bean
 *   {@link Configuration} 注解用于配置Spring Boot
 *   {@link SpringBootApplication} 注解包含了上述三个注解, exclude属性防止Spring Boot自动配置一些不需要的配置
 * </p>
 *
 * @author zachard
 * @version 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HelloApplication extends WebMvcConfigurerAdapter {
	
	static {
		try {
			//初始化自定义日志系统
//			String log4jPath = HelloApplication.class.getClassLoader().getResource("")
//					.getPath() + "log4j.properties";
//			PropertyConfigurator.configure(log4jPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 项目启动入口方法
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		//设置系统属性方式彻底禁止Spring Boot重启
		//System.setProperty("spring.devtools.restart.enabled", "true");
		
		/* 通过SpringApplication类启动一个Spring应用
		 * run方法中第一个参数声明Spring的组件，第二个参数传递所有命令行参数
		 */
		SpringApplication.run(HelloApplication.class, args);
	}
	
	/**
	 * 注册不需要执行任何逻辑,只是跳转页面的url及逻辑视图映射
	 * 
	 * @param   registry  
	 */
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/login").setViewName("login");
    }

}
