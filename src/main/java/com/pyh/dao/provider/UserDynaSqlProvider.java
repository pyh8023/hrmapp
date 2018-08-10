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
					SET("username="+user.getUsername());
				if(user.getLoginname()!=null)
					SET("loginname = "+user.getLoginname());
				if(user.getPassword()!=null)
					SET("password ="+user.getPassword());
				if(user.getStatus()!=null)
					SET("status = "+user.getStatus());
				if(user.getCreateDate()!=null)
					SET("createDate="+user.getCreateDate());
				WHERE("ID=" +user.getId());
			}
		}.toString();
	}
	
	public String selectWithParam(final Map<String,Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user")!=null) {
					User user = (User) params.get("user");
					if(user.getUsername()!=null&&!"".equals(user.getUsername()))
						WHERE("username="+user.getUsername());
					if(user.getStatus()!=null&& !"".equals(user.getStatus()))
						WHERE("status="+user.getStatus());
				}
			}
		}.toString();
		if(params.get("pageModel")!=null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
		}
		return sql;
	}
	
	public String count(Map<String,Object> params) {
		return null;
		
	}
	
	public String insertUser(User user) {
		return null;
		
	}

}
