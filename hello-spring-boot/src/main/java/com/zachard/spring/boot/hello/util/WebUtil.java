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

package com.zachard.spring.boot.hello.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * 自定义web工具类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class WebUtil {
	
	private static final String X_FORWARDED_FOR = "x-forwarded-for";
	private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
	private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
	private static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
	private static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
	
	private static final String UNKNOW_IP = "unknown";
	
	/**
	 * 根据request对象获取客户端ip地址
	 * 
	 * @param request    请求对象
	 * @return           客户端ip地址
	 */
	public static String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader(X_FORWARDED_FOR);
		
		if (StringUtils.isEmpty(ip) || UNKNOW_IP.equalsIgnoreCase(ip)) {
			ip = request.getHeader(PROXY_CLIENT_IP);
		}
		
		if (StringUtils.isEmpty(ip) || UNKNOW_IP.equalsIgnoreCase(ip)) {
			ip = request.getHeader(WL_PROXY_CLIENT_IP);
		}
		
		if (StringUtils.isEmpty(ip) || UNKNOW_IP.equalsIgnoreCase(ip)) {
			ip = request.getHeader(HTTP_CLIENT_IP);
		}
		
		if (StringUtils.isEmpty(ip) || UNKNOW_IP.equalsIgnoreCase(ip)) {
			ip = request.getHeader(HTTP_X_FORWARDED_FOR);
		}
		
		if (StringUtils.isEmpty(ip) || UNKNOW_IP.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		
		return ip;
	}

}
