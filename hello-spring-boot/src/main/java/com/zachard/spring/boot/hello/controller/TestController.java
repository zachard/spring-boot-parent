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

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zachard.spring.boot.hello.request.test.InsertCustomerReq;
import com.zachard.spring.boot.hello.request.test.InsertOrderReq;
import com.zachard.spring.boot.hello.util.WebUtil;

/**
 * <code>TestController</code>用于对Spring的Controller属性进行研究测试
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "/demo")
public class TestController {
	
	/**
	 * SpringBoot去除提交表单中重复元素测试
	 * <pre>
	 *     例如: 当客户的订单中列表为: 
	 *     [
	 *         {
	 *             "name": "order.01",
	 *             "price": 50
	 *         },
	 *         {
	 *             "name": "order.01",
	 *             "price": 50
	 *         }
	 *     ]
	 *     时，在后端的{@link InsertCustomerReq#getOrders()}方法中只能获取到一个<code>name</code>
	 *     为<code>order.01</code>, <code>price</code>为<code>50</code>的订单
	 * </pre>
	 * @param req
	 */
	@RequestMapping(value = "/validateRepeatElement", method = {RequestMethod.POST})
	public void validateRepeatElement(@RequestBody InsertCustomerReq req) {
		System.err.println("--validateRepeatEelement的请求参数为: " + JSON.toJSONString(req));
		Set<InsertOrderReq> orders = req.getOrders();
		System.err.println("请求参数中订单的个数为: " + orders.size());
		
		orders.forEach(order -> {
			System.err.println("订单对象为: " + order);
			System.err.println("订单名称为: " + order.getName() + "; 订单价格为: " + order.getPrice());
		});
	}
	
	/**
	 * SpringBoot获取请求客户端IP地址
	 * 
	 * @param request    HTTP请求对象
	 */
	@RequestMapping(value = "/getClientIp", method={RequestMethod.POST})
	public void getClientIp(HttpServletRequest request) {
		System.err.println(WebUtil.getClientIp(request));
	}

}
