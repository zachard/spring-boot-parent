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

package com.zachard.spring.boot.hello.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zachard.spring.boot.hello.service.ReaderService;

/**
 * 覆盖Spring Boot自动配置示例, 示例中覆盖的是Spring Security的自动配置
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
@EnableWebSecurity
public class OverrideSpringBootConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ReaderService readerService;
	
	/**
	 * 配置HTTP拦截权限
	 * 
	 * @param  http  HTTP权限拦截配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		    .antMatchers("/book**").access("hasRole('READER')")
//		    .and().formLogin()
//		    .loginPage("/login")
//		    .failureUrl("/login?error=true")
//		    .and().csrf();
	}
	
	/**
	 * 配置权限认证的用户
	 * 
	 * @param  auth  权限管理对象
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// UserDetailsService接口是用于加载特定用户数据的接口
		auth.userDetailsService(new UserDetailsService() {

			/**
			 * 根据用户名加载用户详情
			 * 
			 * @param username  用户名
			 * @return  用户详细信息, 必须返回 UserDetails 对象
			 */
			@Override
			public UserDetails loadUserByUsername(String username) 
					throws UsernameNotFoundException {
				UserDetails userDetails = readerService.findByUsername(username);
				
				if (userDetails != null) {
					return readerService.findByUsername(username);
				}
				
				throw new UsernameNotFoundException("用户名为: " + username + "的用户不存在.");
			}
			
		});
	}

}
