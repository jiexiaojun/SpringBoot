/**
 * @项目名称：spring-boot-jdbc
 * @文件名称：WebFluxConf.java
 * @所属包名：com.allen.webflux
 * @创建时间：2019年6月26日上午10:42:19
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @类名称：WebFluxConf
 * @类描述：
 * @创建人：allen
 * @创建时间：2019年6月26日 上午10:42:19
 */
@Configuration
public class WebFluxConfiguration {

	@Bean
	public RouterFunction<ServerResponse> saveUser(UserHandler userHandler) {
		return RouterFunctions.route(RequestPredicates.POST("/web/flux/user/save"),
				userHandler::save);
	}

	@Bean
	public RouterFunction<ServerResponse> findAllUser(UserHandler userHandler) {
		return RouterFunctions.route(RequestPredicates.POST("/web/flux/findAll"),
				userHandler::findAll);
	}
}

