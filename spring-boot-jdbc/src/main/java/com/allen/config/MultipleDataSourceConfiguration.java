/**
 * @项目名称：spring-boot-jdbc
 * @文件名称：MultipleDataSourceConfiguration.java
 * @所属包名：com.allen.config
 * @创建时间：2019年6月26日下午2:15:44
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @类名称：MultipleDataSourceConfiguration
 * @类描述：多数据源
 * @创建人：allen
 * @创建时间：2019年6月26日 下午2:15:44
 */
@Configuration
@SuppressWarnings("rawtypes")
public class MultipleDataSourceConfiguration {



	@Bean
	@Primary
	public DataSource masterDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		DataSource dateSource = dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver").url(
				"jdbc:mysql://localhost:3306/springjdbcdemo?characterEncoding=UTF-8&rewriteBatchedStatements=true&serverTimezone=UTC")
				.username("root").password("slpcb456852.").build();
		return dateSource;
	}

	@Bean
	public DataSource slaveDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		DataSource dateSource = dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver").url(
				"jdbc:mysql://localhost:3306/springjdbcdemo?characterEncoding=UTF-8&rewriteBatchedStatements=true&serverTimezone=UTC")
				.username("root").password("slpcb456852.").build();
		return dateSource;
	}

}

