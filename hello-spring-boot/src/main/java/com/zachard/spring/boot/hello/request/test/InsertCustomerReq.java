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

package com.zachard.spring.boot.hello.request.test;

import java.io.Serializable;
import java.util.Set;

/**
 * 新增客户请求实体
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class InsertCustomerReq implements Serializable {

	private static final long serialVersionUID = 7575308988946222458L;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 订单列表
	 */
	private Set<InsertOrderReq> orders;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the orders
	 */
	public Set<InsertOrderReq> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<InsertOrderReq> orders) {
		this.orders = orders;
	}

}
