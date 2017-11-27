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

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 读者对应数据库Model
 * <pre>
 *     (1) {@link UserDetails}接口主要用于提供核心的用户信息
 *     (2) 因为Spring Security需要返回{@link UserDetails}类型的数据, 
 *         所以实现了该接口(实现了此接口后表示为Spring Security中的用户),正常设计是不应该实现该接口的
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class Reader implements UserDetails {
	
	/**
	 * 序列化ID，显示声明时有如下好处:
	 * <pre>
	 *   1. 提高程序运行效率
	 *   2. 避免不同操作系统间计算方式不一致而导致生成值不一致
	 *   3. 避免类文件修改后导致同一个类出现不同ID值情况
	 * </pre>
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String fullname;
	private String password;
	
	/**
	 * 默认构造器
	 */
	public Reader() {
		
	}

	/**
	 * 去除数据库之后, 方便初始数据的构造方法
	 * 
	 * @param username
	 * @param fullname
	 * @param password
	 */
	public Reader(String username, String fullname, String password) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.password = password;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取用户所具有的权限
	 * 
	 * @return   用户所具有的权限(暂时通过硬编码指定为读者角色)
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("READER"));
	}

	/**
	 * 判断账户是否过期
	 * 
	 * @return  过期返回<code>false</code>, 否则返回<code>true</code>
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * 判断用户是否被锁定
	 * 
	 * @return   锁定返回<code>false</code>, 否则返回<code>true</code>
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 判断用户密码是否已经过期
	 * <pre>
	 *     密码已过期的用户将授权失败
	 * </pre>
	 * 
	 * @return    密码过期返回<code>false</code>, 否则返回<code>true</code>
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 判断用户是否有效
	 * <pre>
	 *     无效的用户将授权失败
	 * </pre>
	 * 
	 * @return    用户有效返回<code>true</code>, 用户失效返回<code>false</code>
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
