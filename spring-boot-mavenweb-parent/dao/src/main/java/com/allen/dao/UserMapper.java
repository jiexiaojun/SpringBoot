package com.allen.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.allen.domain.UserEntity;
import com.allen.domain.UserSexEnum;

public interface UserMapper {

	@Select("SELECT * FROM users")
	@Results({@Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name")})
	List<UserEntity> getAll();

	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({@Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name")})
	UserEntity getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex,nick_name) VALUES(#{userName}, #{passWord}, #{userSex}, #{nickName})")
	void insert(UserEntity user);

	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName},user_sex=#{userSex} WHERE id =#{id}")
	void update(UserEntity user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}
