package com.youxiue.dbsharding.simple.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

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
public interface DictDao {

    @Insert("insert into t_dict (dict_id, type,code,value) values (#{dictId}, #{type}, #{code}, #{value})")
    void insert(@Param("dictId") Long dictId, @Param("type") String type,@Param("code") String code, @Param("value") String value);

    @Select("<script>" +
            "select * from t_dict t " +
            "where t.dict_id in " +
            "<foreach collection='ids' open='(' separator=',' close=')' item='id'>" +
            " #{id} " +
            "</foreach>" +
            "</script>")
    List<Map> selectOrderByIds(@Param("ids") List<Long> ids);


    @Delete("delete from t_dict where dict_id = #{dictId}")
    int deleteDict(@Param("dictId")Long dictId);


}
