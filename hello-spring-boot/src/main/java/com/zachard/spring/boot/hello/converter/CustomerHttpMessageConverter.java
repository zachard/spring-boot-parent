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

package com.zachard.spring.boot.hello.converter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.zachard.spring.boot.hello.constant.HelloConstant;
import com.zachard.spring.boot.hello.model.User;

/**
 * {@link HttpMessageConverter} 接口主要用于转化HTTP请求及响应
 * <pre>
 *     {@link AbstractHttpMessageConverter} 为 {@link HttpMessageConverter}接口的实现类
 *     通过{@link #setSupportedMediaTypes(java.util.List)}设置支持的MediaTypes
 *     此外,它还支持将<code>Content-Type</code>及<code>Content-Length</code>写入响应信息
 * </pre>
 * <pre>
 *     
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class CustomerHttpMessageConverter extends AbstractHttpMessageConverter<User> {
	
	/**
	 * HTTP中媒体类型
	 */
	private static final String MEDIA_TYPE = "application";
	
	/**
	 * HTTP中媒体子子类型
	 */
	private static final String MEDIA_SUB_TYPE = "x-wisely";
	
	/**
	 * HTTP Message Converter字符集
	 */
	private static Charset charset = Charset.forName(HelloConstant.DEFAULT_CHARSET);
	
	/**
	 * 自定义HTTP Message转换器
	 */
	public CustomerHttpMessageConverter() {
		/*
		 * MediaType	作为MimeType的子类，主要用于支持HTTP说明中的quality parameters
		 * type为Mime的类型,sub_type为Mime的子类型
		 */
		super(new MediaType(MEDIA_TYPE, MEDIA_SUB_TYPE, charset));
	}

	/**
	 * 
	 */
	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage input)
			throws IOException, HttpMessageNotReadableException {
		String message = StreamUtils.copyToString(input.getBody(), charset);
		
		// 属性与属性之间用;相隔
		String[] propertyArr = message.split(";");
		
		Arrays.asList(propertyArr).forEach(property -> {
			
		});
		
		return null;
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void writeInternal(User user, HttpOutputMessage output)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}

}
