package com.youxiue.dbsharding.simple;

import com.youxiue.dbsharding.simple.dao.DictDao;
import com.youxiue.dbsharding.simple.dao.OrderDao;
import com.youxiue.dbsharding.simple.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: xfb
 * @projectName: sharding-test->ShardingJdbcSimpleApplicationTest
 * @description: TODO
 * @date: 2020/05/31 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcSimpleApplication.class})
public class ShardingJdbcSimpleApplicationTest{

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DictDao dictDao;

    @Test
    public void insertTest(){
        for (int i = 0; i < 20; i++) {
            orderDao.insert(new BigDecimal(i), (long)i, "success");
        }
    }

    @Test
    public void selectTest(){
        ArrayList<Long> list = new ArrayList<>();
        list.add(474151763713196032l);
        list.add(474151763818053632l);
        //list.add(474151763763527681l);
        //list.add(474151763939688449l);
        List<Map> orderList = orderDao.selectOrderByIds(list);
        orderList.forEach(System.out::println);
    }
    @Test
    public void selectOrderByUserIdAndIds(){
        ArrayList<Long> list = new ArrayList<>();
        list.add(474151763713196032l);
        list.add(474151763818053632l);
        //list.add(474151763763527681l);
        //list.add(474151763939688449l);
        List<Map> orderList = orderDao.selectOrderByUserIdAndIds(4l, list);
        orderList.forEach(System.out::println);
    }

    @Test
    public void insertUser(){
        for (int i = 20; i < 24; i++) {
            // 配置了主从数据库后, 将会插入到主数据库中
            userDao.insert((long)i, "JOJO"+i);
        }
    }

    @Test
    public void selectUser(){
        ArrayList<Long> list = new ArrayList<>();
        list.add(10l);
        list.add(11l);
        //list.add(474151763763527681l);
        //list.add(474151763939688449l);
        // 配置了主从数据库后, 将会从 从库中查询
        List<Map> userList = userDao.selectOrderByIds(list);
        userList.forEach(System.out::println);
    }


    @Test
    public void insertDict(){
        dictDao.insert(1l, "user_type", "0", "管理员");
        dictDao.insert(2l, "user_type", "1", "操作员");
    }

    @Test
    public void deleteDict(){
        dictDao.deleteDict(1l);
        dictDao.deleteDict(2l);
    }
}
