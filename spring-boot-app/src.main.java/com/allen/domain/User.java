/**
 * @项目名称：spring-boot-app
 * @文件名称：User.java
 * @所属包名：com.allen.domain
 * @创建时间：2019年6月28日上午10:33:48
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.domain;

/**
 * @类名称：User
 * @类描述：
 * @创建人：allen
 * @创建时间：2019年6月28日 上午10:33:48
 */

public class User {

	private long id;
	private String name;

	/**
	 * id.
	 *
	 * @return  the id
	 * @since   JDK 1.8
	 */
	public long getId() {
		return id;
	}

	/**
	 * id.
	 *
	 * @param   id    the id to set
	 * @since   JDK 1.8
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * name.
	 *
	 * @return  the name
	 * @since   JDK 1.8
	 */
	public String getName() {
		return name;
	}

	/**
	 * name.
	 *
	 * @param   name    the name to set
	 * @since   JDK 1.8
	 */
	public void setName(String name) {
		this.name = name;
	}
}

