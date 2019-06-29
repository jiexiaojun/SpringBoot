/*
 * Copyright 2012-2018 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * 本示例参数于：
 * https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot
 * -sample-web-ui
 */
package com.webthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import com.webthymeleaf.model.Message;
import com.webthymeleaf.repository.InMemoryMessageRepository;
import com.webthymeleaf.repository.MessageRepository;

/**
 * 
 * @类名称：WebThymeleafApplication
 * @类描述：spring-boot-web-Thymeleaf的demo
 * 实现页面展示。增删改查的功能。暂时未与数据库交互利用的缓存。
 * @创建人：jie.xiaojun
 * @创建时间：2018年8月30日 上午11:26:45
 */
@SpringBootApplication
public class WebThymeleafApplication {

	@Bean
	public MessageRepository messageRepository() {
		return new InMemoryMessageRepository();
	}

	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository().findMessage(Long.valueOf(id));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WebThymeleafApplication.class, args);
	}

}
