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
import java.util.Objects;

/**
 * 新增订单请求实体
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class InsertOrderReq implements Serializable {

	private static final long serialVersionUID = -6394868231031631291L;

	/**
	 * 订单名称
	 */
	private String name;
	
	/**
	 * 订单价格
	 */
	private Integer price;

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
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		
		if (this == object) {
			return true;
		}
		
		if (this.getClass() != object.getClass()) {
			return false;
		}
		
		InsertOrderReq orderReq = (InsertOrderReq) object;
		
		if (Objects.equals(this.getName(), orderReq.getName()) 
				&& Objects.equals(this.getPrice(), orderReq.getPrice())) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() * price.hashCode();
	}
}
