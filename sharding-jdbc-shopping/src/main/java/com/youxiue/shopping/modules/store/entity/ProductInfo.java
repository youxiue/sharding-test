package com.youxiue.shopping.modules.store.entity;

import java.math.BigDecimal;
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
@TableName("product_info")
@ApiModel(value="ProductInfo对象", description="")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "product_info_id", type = IdType.ASSIGN_ID)
    private Long productInfoId;

    @ApiModelProperty(value = "所属店铺id")
    @TableField("store_info_id")
    private Long storeInfoId;

    @ApiModelProperty(value = "商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "规格")
    @TableField("spec")
    private String spec;

    @ApiModelProperty(value = "产地")
    @TableField("region_code")
    private String regionCode;

    @ApiModelProperty(value = "商品价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "商品图片")
    @TableField("image_url")
    private String imageUrl;


    @ApiModelProperty(value = "商品描述")
    @TableField(exist = false)
    private String descript;

    @ApiModelProperty(value = "商品描述")
    @TableField(exist = false)
    private String placeOfOrigin;




}
