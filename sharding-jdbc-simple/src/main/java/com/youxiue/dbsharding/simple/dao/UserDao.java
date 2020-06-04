package com.youxiue.dbsharding.simple.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: xfb
 * @projectName: sharding-test->UserDao
 * @description: TODO
 * @date: 2020/06/01 10:14
 */
@Mapper
@Component
public interface UserDao {

    @Insert("insert into t_user (user_id, fullname) values (#{userId}, #{fullname})")
    void insert(@Param("userId") Long userId, @Param("fullname") String fullname);

    @Select("<script>" +
            "select * from t_user t, t_dict d " +
            "where t.user_type = d.code and t.user_id in " +
            "<foreach collection='ids' open='(' separator=',' close=')' item='id'>" +
            " #{id} " +
            "</foreach>" +
            "</script>")
    List<Map> selectOrderByIds(@Param("ids") List<Long> ids);


}
