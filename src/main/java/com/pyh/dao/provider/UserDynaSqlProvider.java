package com.pyh.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.pyh.domain.User;

import static com.pyh.util.HrmConstants.USERTABLE;

public class UserDynaSqlProvider {
	
	public String updateUser(final User user) {
		return new SQL() {
			{
				UPDATE(USERTABLE);
				if(user.getUsername()!=null)
					SET(" username = #{username}");
				if(user.getLoginname()!=null)
					SET(" loginname = #{loginname}");
				if(user.getPassword()!=null)
					SET(" password = #{password}");
				if(user.getStatus()!=null)
					SET(" status = #{status}");
				if(user.getCreateDate()!=null)
					SET(" createDate = #{createDate}");
				WHERE("ID=" +user.getId());
			}
		}.toString();
	}
	
	/**
	 * 动态分页查询 
	 * @param params
	 * @return
	 */
	public String selectWithParam(final Map<String,Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user")!=null) {
					User user = (User) params.get("user");
					if(user.getUsername()!=null&&!"".equals(user.getUsername()))
						WHERE(" username like CONCAT('%',#{user.username},'%') ");
					if(user.getStatus()!=null)
						WHERE(" status = #{user.status} ");
				}
			}
		}.toString();
		if(params.get("pageModel")!=null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
		}
		return sql;
	}
	
	/**
	 * 动态查询总数
	 * @param params
	 * @return
	 */
	public String count(final Map<String,Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user")!=null) {
					User user = (User) params.get("user");
					if(user.getUsername()!=null&&!"".equals(user.getUsername()))
						WHERE(" username like CONCAT('%',#{user.username},'%') ");
					if(user.getStatus()!=null)
						WHERE(" status = #{user.status} ");
				}
			}
		}.toString();
	}
	
	public String insertUser(final User user) {
		return new SQL() {
			{
				INSERT_INTO(USERTABLE);
				if(user.getUsername()!=null&& !"".equals(user.getUsername()))
					VALUES("username ","#{username}");
				if(user.getLoginname()!=null&& !"".equals(user.getLoginname()))
					VALUES("loginname","#{loginname}");
				if(user.getPassword()!=null&& !"".equals(user.getPassword()))
					VALUES("password","#{password}");
				if(user.getStatus()!=null)
					VALUES("status","#{status}");
			}
		}.toString();
	}

}
