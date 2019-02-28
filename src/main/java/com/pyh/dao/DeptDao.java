package com.pyh.dao;

import com.pyh.dao.provider.DeptDynaSqlProvider;
import com.pyh.domain.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.pyh.util.HrmConstants.DEPTTABLE;

public interface DeptDao {

    @Select("select * from "+ DEPTTABLE +" ")
    List<Dept> selectAllDept();

    @Select("select * from "+DEPTTABLE +" where id = #{id}")
    Dept selectById(int id);

    @Delete("delete from "+DEPTTABLE + " where id = #{id}")
    void deleteById(int id);

    @SelectProvider(type = DeptDynaSqlProvider.class,method = "selectWithParam")
    List<Dept> selectByPage(Map<String,Object> params);

    @UpdateProvider(type = DeptDynaSqlProvider.class,method = "updateDept")
    void update(Dept dept);

    @InsertProvider(type = DeptDynaSqlProvider.class,method = "insertDept")
    void save(Dept dept);

    @SelectProvider(type = DeptDynaSqlProvider.class,method = "count")
    int count(Map<String,Object> params);
}
