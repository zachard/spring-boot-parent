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

import java.io.Serializable;

/**
 * 用户对象实体类
 * <p></p>
 *
 * @author zachard
 * @version 1.0.0
 */
public class User implements Serializable {

	/**
	 * 序列化ID，显示声明时有如下好处:
	 * <pre>
	 *   1. 提高程序运行效率
	 *   2. 避免不同操作系统间计算方式不一致而导致生成值不一致
	 *   3. 避免类文件修改后导致同一个类出现不同ID值情况
	 * </pre>
	 */
	private static final long serialVersionUID = 7850379309987537800L;
	
	/**
	 * 用户编号
	 */
	private String userNo;
	
	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
