
package com.allen.config;

import java.util.Collection;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.allen.domain.User;
import com.allen.repository.UserRepository;
import reactor.core.publisher.Flux;
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

	public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
		System.err.println(serverRequest.uri());
		// 在sprign web mvc 中使用@RequestBody
		// 在sprign web Flux 中使用ServerRequest
		Collection<User> users = userRepository.findAll();
		Flux<User> userFlux = Flux.fromIterable(users);
		return ServerResponse.ok().body(userFlux, User.class);
	}

}

