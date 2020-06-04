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
 * @projectName: sharding-test->OrderDao
 * @description: TODO
 * @date: 2020/05/31 14:26
 */
@Mapper
@Component
public interface OrderDao {

    @Insert("insert into t_order (price, user_id, status) values (#{price}, #{userId}, #{status})")
    void insert(@Param("price") BigDecimal price,@Param("userId") Long userId,@Param("status") String status);

    @Select("<script>" +
            "select * from t_order t " +
            "where t.order_id in " +
            "<foreach collection='ids' open='(' separator=',' close=')' item='id'>" +
            " #{id} " +
            "</foreach>" +
            "</script>")
    List<Map> selectOrderByIds(@Param("ids") List<Long> ids);

    @Select("<script>" +
            "select * from t_order t " +
            "where t.order_id in " +
            "<foreach collection='ids' open='(' separator=',' close=')' item='id'>" +
            " #{id} " +
            "</foreach>" +
            " and user_id = #{userId}" +
            "</script>")
    List<Map> selectOrderByUserIdAndIds(@Param("userId")Long userId,@Param("ids") List<Long> ids);
}
