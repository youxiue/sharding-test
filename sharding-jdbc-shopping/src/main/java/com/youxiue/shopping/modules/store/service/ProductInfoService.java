package com.youxiue.shopping.modules.store.service;

import com.youxiue.shopping.modules.store.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xfb
 * @since 2020-06-04
 */
public interface ProductInfoService extends IService<ProductInfo> {

    void add(ProductInfo productInfo);

    List<ProductInfo> queryProduct(int page ,int pageSize);
}
