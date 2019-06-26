/**
 * @项目名称：spring-boot-jdbc
 * @文件名称：UserHandler.java
 * @所属包名：com.allen.webflux
 * @创建时间：2019年6月26日上午10:45:34
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.webflux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.allen.domain.User;
import com.allen.repository.UserRepository;
import reactor.core.publisher.Mono;

/**
 * @类名称：UserHandler
 * @类描述：
 * @创建人：allen
 * @创建时间：2019年6月26日 上午10:45:34
 */
@Component
public class UserHandler {

	private final UserRepository userRepository;

	public UserHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Mono<ServerResponse> save(ServerRequest serverRequest) {
		// 在sprign web mvc 中使用@RequestBody
		// 在sprign web Flux 中使用ServerRequest
		System.out.println("UserHandler Thread:" + Thread.currentThread().getName());
		Mono<User> userMono = serverRequest.bodyToMono(User.class);
		Mono<Boolean> booleanMono = userMono.map(userRepository::save);
		return ServerResponse.ok().body(booleanMono, boolean.class);
	}

}

