/**
 * @项目名称：spring-boot-app
 * @文件名称：WebFluxConfiguration.java
 * @所属包名：com.allen.config
 * @创建时间：2019年6月28日上午11:23:31
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.config;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.allen.domain.User;
import com.allen.repository.UserRepository;
import reactor.core.publisher.Flux;

/**
 * @类名称：WebFluxConfiguration
 * @类描述：
 * @创建人：allen
 * @创建时间：2019年6月28日 上午11:23:31
 */
@Configuration
public class WebFluxConfiguration {

	@Bean
	@Autowired
	public RouterFunction<ServerResponse> RouterFlux1Users(UserRepository userRepository) {
		Collection<User> users = userRepository.findAll();
		Flux<User> userFlux = Flux.fromIterable(users);
//		Mono<Collection<User>> mono = Mono.just(users);
		return RouterFunctions.route(RequestPredicates.GET("/web/flux/users1"),
				request -> ServerResponse.ok().body(userFlux, User.class));
	}


	// 使用HandlerFunction
	@Bean
	public RouterFunction<ServerResponse> RouterFlux2Users(UserHandler userHandler) {
		return RouterFunctions.route(RequestPredicates.GET("/web/flux/users2"),
				userHandler::findAll);
	}

}

