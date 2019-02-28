package com.pyh.dao.provider;

import com.pyh.domain.Dept;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.pyh.util.HrmConstants.DEPTTABLE;

public class DeptDynaSqlProvider {

    public String selectWithParam(final Map<String,Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(DEPTTABLE);
                if (params.get("dept")!=null){
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() !=null && !dept.getName().equals("")){
                        WHERE("name LIKE CONCAT ('%',#{dept.name},'%')");
                    }
                }
            }
        }.toString();

        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }
        return sql;
    }

    public String count(final Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(DEPTTABLE);
                if (params.get("dept")!=null){
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() !=null && !dept.getName().equals("")){
                        WHERE("name LIKE CONCAT ('%',#{dept.name},'%')");
                    }
                }
            }
        }.toString();
    }

    public String updateDept(final Dept dept){
        return new SQL(){
            {
                UPDATE(DEPTTABLE);
                if (dept.getName()!=null && !dept.getName().equals("")){
                    SET("name = #{name}");
                }
                if (dept.getRemark()!=null){
                    SET("remark = #{remark)");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String insertDept(final Dept dept){
        return new SQL(){
            {
                INSERT_INTO(DEPTTABLE);
                if (dept.getName()!=null && !dept.getName().equals("")){
                    VALUES("name"," #{name}");
                }
                if (dept.getRemark()!=null){
                    VALUES("remark","#{remark)");
                }
            }
        }.toString();
    }
}
