package com.itheima.dao.impl;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 要想从数据库中取出数据必须有四个属性
 *      数据库驱动,连接数据库的地址,数据库用户名称,数据库密码
 */
public class ItemDaoImpl implements ItemsDao {
    public List<Items> findAll() {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Items> list = new ArrayList<Items>();
        Items items;

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 定义sql
            String sql = "select * from items";

            // 获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///maven","root","7952");

            // 获取操作数据库的对象
            ps = connection.prepareCall(sql);

            // 执行数据库查询操作
            rs = ps.executeQuery();

            // 把数据库结果集转成java的list集合
            while(rs.next()){
                items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(ps != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(rs != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
