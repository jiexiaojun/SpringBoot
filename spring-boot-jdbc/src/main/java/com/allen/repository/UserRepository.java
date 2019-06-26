/**
 * @项目名称：spring-boot-jdbc
 * @文件名称：UserRepository.java
 * @所属包名：com.allen.repository
 * @创建时间：2019年6月26日上午10:27:00
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.allen.domain.User;

/**
 * @类名称：UserRepository
 * @类描述：用户的仓储 
 * @创建人：allen
 * @创建时间：2019年6月26日 上午10:27:00
 */

@Repository
@SuppressWarnings("unused")
public class UserRepository {
	// 方式二
	private final DataSource dataSource;
	private final DataSource masterDataSource;
	private final DataSource slaveDataSource;
	private final JdbcTemplate jdbcTemplate;
	private final PlatformTransactionManager platformTransactionManager;

	/**
	 * Creates a new instance of UserRepository.
	 *
	 * @param dataSource
	 * @param masterDataSource
	 * @param slaveDataSource
	 */
	@Autowired
	public UserRepository(DataSource dataSource,
			@Qualifier("masterDataSource") DataSource masterDataSource,
			@Qualifier("slaveDataSource") DataSource slaveDataSource, JdbcTemplate jdbcTemplate,
			PlatformTransactionManager platformTransactionManager) {
		super();
		this.dataSource = dataSource;
		this.masterDataSource = masterDataSource;
		this.slaveDataSource = slaveDataSource;
		this.jdbcTemplate = jdbcTemplate;
		this.platformTransactionManager = platformTransactionManager;
	}


	// 这种方式是自动提交
	public boolean jdbcsave(User user) {
		System.err.println("save user:" + user + "Thread:" + Thread.currentThread().getName());
		boolean success = false;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement prepareStatement =
					connection.prepareStatement("insert into t_user(name) value(?)");
			prepareStatement.setString(1, user.getName());
			success = prepareStatement.executeUpdate() > 0;
			prepareStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
		return success;
	}

	// 这种方式是spring先关闭自动提交 然后提供rollback粒度 最后自己一系列验证通过之后在commit
	@Transactional
	public boolean transactionalsave(User user) {
		System.err.println("save user:" + user + "Thread:" + Thread.currentThread().getName());
		boolean success = false;

		success = jdbcTemplate.execute("insert into t_user(name) value(?)",
				new PreparedStatementCallback<Boolean>() {

					@Override
					@Nullable
					public Boolean doInPreparedStatement(PreparedStatement prepareStatement)
							throws SQLException, DataAccessException {
						prepareStatement.setString(1, user.getName());
						return prepareStatement.executeUpdate() > 0;
					}

				});
		return success;
	}

	//
	public boolean save(User user) {
		System.err.println("save user:" + user + "Thread:" + Thread.currentThread().getName());
		boolean success = false;

		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		// 开始事物
		TransactionStatus transactionStatus =
				platformTransactionManager.getTransaction(transactionDefinition);

		success = jdbcTemplate.execute("insert into t_user(name) value(?)",
				new PreparedStatementCallback<Boolean>() {

					@Override
					@Nullable
					public Boolean doInPreparedStatement(PreparedStatement prepareStatement)
							throws SQLException, DataAccessException {
						prepareStatement.setString(1, user.getName());
						return prepareStatement.executeUpdate() > 0;
					}

				});

		platformTransactionManager.commit(transactionStatus);
		return success;
	}


	public Collection<User> finall() {
		return Collections.emptyList();

	}

}

