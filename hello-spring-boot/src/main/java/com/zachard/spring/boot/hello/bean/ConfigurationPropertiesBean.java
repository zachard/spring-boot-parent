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

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 用户配置属性
 * <pre>
 *     (1) {@link ConfigurationProperties}用于添加到被{@link Bean}注解的方法或是被
 *         {@link Configuration}注解的类, 并用于绑定或校验外部属性(比如: 从properties文件中读取的属性)
 *     (2) 与{@link Value}注解不同的是, {@link ConfigurationProperties}不会执行<code>SpEL</code>
 *         表达式, 因为属性值是在外部初始化的(好想没太懂), {@link ConfigurationProperties}一般用于配置
 *         比较多的情况, 而{@link Value}一般用于配置较少的情况
 *         {@link ConfigurationProperties}可以添加属性的前缀, 例如: 下面注解的"amazon", 并且它的属性
 *         配置可以是驼峰形式, 也可以是下划线分割, 也可以是中线分割
 *         {@link ConfigurationProperties}默认从application.properties或application.yaml文件中读取,
 *         但可以通过<code>@PropertySource("classpath:xxx.yml")</code>配置其他属性文件
 *     (3) {@link ConfigurationProperties}属性可以与{@link NotNull}等数据校验配合使用, 在项目启动的时候,
 *         Spring Boot就会将配置文件的属性装配到成员变量,当校验不通过时,项目无法启动
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Component
@PropertySource("classpath:amazon.properties")
@ConfigurationProperties("amazon")
public class ConfigurationPropertiesBean {
	
	@NotBlank(message = "编号不能为空")
	private String associateId;

	/**
	 * @return the associateId
	 */
	public String getAssociateId() {
		return associateId;
	}

	/**
	 * @param associateId the associateId to set
	 */
	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

}
