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
@TableName("store_info")
@ApiModel(value="StoreInfo对象", description="")
public class StoreInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "店铺名称")
    @TableField("store_name")
    private String storeName;

    @ApiModelProperty(value = "信誉等级")
    @TableField("reputation")
    private Integer reputation;

    @ApiModelProperty(value = "店铺所在地")
    @TableField("region_code")
    private String regionCode;


}
