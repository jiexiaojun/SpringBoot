package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @类名称：WebApplication
 * @类描述：spring-boot-web的demo
 * 其中有配置redis启动前必须开启redis服务
 * @创建人：jie.xiaojun
 * @创建时间：2018年8月30日 上午11:30:32
 */
@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
