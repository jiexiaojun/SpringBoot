package com.allen.mapper.test2;

import java.util.List;
import org.apache.ibatis.annotations.*;
import com.allen.entity.UserEntity;
import com.allen.enums.UserSexEnum;

public interface User2Mapper {


	@Select("SELECT * FROM users")
	@Results({
			@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name")
	})
	List<UserEntity> getAll();

	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
			@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name")
	})
	UserEntity getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(UserEntity user);

	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(UserEntity user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}