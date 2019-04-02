package com.itheima.test;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {

    @Test
    public void testDaoFindById(){
        // 获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 从容器中拿到所需要的dao代理对象
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);

        // 调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());
    }

    @Test
    public void testServiceFindById(){
        // 获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 从容器中拿到所需要的dao代理对象
        ItemsService itemsService = ac.getBean(ItemsService.class);

        // 调用方法
        Items items = itemsService.findById(1);
        System.out.println(items.getName());
    }
}
