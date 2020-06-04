package com.youxiue.shopping.modules;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youxiue.shopping.modules.store.entity.ProductInfo;
import com.youxiue.shopping.modules.store.mapper.ProductInfoMapper;
import com.youxiue.shopping.modules.store.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: xfb
 * @projectName: sharding-test->ShoppingApplicationTest
 * @description: TODO
 * @date: 2020/06/04 14:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShoppingApplication.class})
public class ShoppingApplicationTest {
    // 添加商品

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductInfoMapper productInfoMapper;


    @Test
    public void productInfoSave(){
        for (int i = 0; i < 17; i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setStoreInfoId(2l)
                    .setDescript("经典典明粥,给你爱的味道")
                    .setProductName("经典典明粥")
                    .setSpec("小碗")
                    .setRegionCode("410000")
                    .setPrice(new BigDecimal(120));
            this.productInfoService.add(productInfo);
        }
    }


    @Test
    public void page(){
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("product_info_id");

        Page<ProductInfo> page = new Page<>(1, 10);

        page = this.productInfoService.page(page);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void queryProduct(){
        List<ProductInfo> productInfos = this.productInfoService.queryProduct(1, 10);
        productInfos.forEach(System.out::println);
    }


    @Test
    public void count(){
        int count = this.productInfoService.count();
        System.out.println(count);
    }

    @Test
    public void groupCount(){
        List<Map> maps = productInfoMapper.selectProductGroupList();
        System.out.println(maps);
    }
}
