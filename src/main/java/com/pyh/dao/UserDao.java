package com.pyh.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.pyh.dao.provider.UserDynaSqlProvider;
import com.pyh.domain.User;
import static com.pyh.util.HrmConstants.USERTABLE;

import java.util.List;
import java.util.Map;

public interface UserDao {
	@Select("select * from "+ USERTABLE +" where ID= #{id}")
	User selectById(@Param("id")int id);
	
	@Select("select * from "+USERTABLE + " where loginname=#{loginname} and password =#{password} ")
	User selectByLoginNameAndPassword(@Param("loginname") String loginname,@Param("password") String password);
	
	@Delete("delete from "+USERTABLE +" where ID = #{id}")
	void deleteById(@Param("id")int id);
	
	@UpdateProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void update(User user);
	
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWithParam")
	List<User> selectByPage(Map<String,Object> params);
	
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String,Object> params);
	
	@InsertProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(User user);
}
