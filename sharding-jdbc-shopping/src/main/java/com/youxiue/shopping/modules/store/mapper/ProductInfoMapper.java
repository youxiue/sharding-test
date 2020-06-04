package com.youxiue.shopping.modules.store.mapper;

import com.youxiue.shopping.modules.store.entity.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xfb
 * @since 2020-06-04
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {

    @Select("select i.*, d.descript, r.region_name placeOfOrigin " +
            "from product_info i join product_descript d on i.product_info_id = d.product_info_id " +
            "join region r on r.region_code = i.region_code order by i.product_info_id desc limit #{start},#{pageSize}")
    List<ProductInfo> selectProductList(@Param("start")int start, @Param("pageSize") int pageSize);

    //分组统计
    @Select("select count(1) as num from product_info group by region_code having num>1 ORDER BY region_code ASC")
    List<Map> selectProductGroupList();
}
