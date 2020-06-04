package com.youxiue.shopping.modules.store.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xfb
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product_descript")
@ApiModel(value="ProductDescript对象", description="")
public class ProductDescript implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "所属商品id")
    @TableField("product_info_id")
    private Long productInfoId;

    @ApiModelProperty(value = "商品描述")
    @TableField("descript")
    private String descript;

    @ApiModelProperty(value = "所属店铺id")
    @TableField("store_info_id")
    private Long storeInfoId;


}
