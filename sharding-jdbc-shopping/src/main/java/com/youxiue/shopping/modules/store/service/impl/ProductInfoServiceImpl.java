package com.youxiue.shopping.modules.store.service.impl;

import com.youxiue.shopping.modules.store.entity.ProductDescript;
import com.youxiue.shopping.modules.store.entity.ProductInfo;
import com.youxiue.shopping.modules.store.mapper.ProductInfoMapper;
import com.youxiue.shopping.modules.store.service.ProductDescriptService;
import com.youxiue.shopping.modules.store.service.ProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xfb
 * @since 2020-06-04
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

    @Autowired
    private ProductDescriptService productDescriptService;

    @Transactional
    public void add(ProductInfo productInfo){
        this.baseMapper.insert(productInfo);

        ProductDescript productDescript = new ProductDescript();
        productDescript.setProductInfoId(productInfo.getProductInfoId())
                .setDescript(productInfo.getDescript())
                .setStoreInfoId(productInfo.getStoreInfoId());
        this.productDescriptService.save(productDescript);
    }

    @Override
    public List<ProductInfo> queryProduct(int page, int pageSize) {
        int start = (page -1 )* pageSize;
        return this.baseMapper.selectProductList(start, pageSize);
    }

}
