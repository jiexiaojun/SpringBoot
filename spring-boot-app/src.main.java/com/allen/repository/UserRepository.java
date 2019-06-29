/**
 * @项目名称：spring-boot-app
 * @文件名称：UserRepository.java
 * @所属包名：com.allen.repository
 * @创建时间：2019年6月28日上午10:35:41
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import com.allen.domain.User;

/**
 * @类名称：UserRepository
 * @类描述：
 * @创建人：allen
 * @创建时间：2019年6月28日 上午10:35:41
 */
@Repository
public class UserRepository {

	private final ConcurrentHashMap<Long, User> repository = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong();


	public boolean save(User user) {
		long id = idGenerator.incrementAndGet();
		user.setId(id);
		return repository.put(id, user) == null;
	}

	public Collection<User> findAll() {
		return repository.values();

	}


}

