package com.itheima.test;

import com.itheima.dao.ItemsDao;
import com.itheima.dao.impl.ItemDaoImpl;
import com.itheima.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {

    @Test
    public void findAllTest(){
        ItemsDao dao = new ItemDaoImpl();
        List<Items> list = dao.findAll();

        for (Items items : list) {
            System.out.println(items.getName());
        }
    }
}
