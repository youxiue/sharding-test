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
@TableName("region")
@ApiModel(value="Region对象", description="")
public class Region implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "地理区域编码")
    @TableField("region_code")
    private String regionCode;

    @ApiModelProperty(value = "地理区域名称")
    @TableField("region_name")
    private String regionName;

    @ApiModelProperty(value = "地理区域级别(省、市、县)")
    @TableField("level")
    private Boolean level;

    @ApiModelProperty(value = "上级地理区域编码")
    @TableField("parent_region_code")
    private String parentRegionCode;


}
