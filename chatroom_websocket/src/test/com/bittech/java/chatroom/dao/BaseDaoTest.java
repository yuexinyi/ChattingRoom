package com.bittech.java.chatroom.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @Author:Star
 * @Date:Created in 10:18 2019/11/3
 * @Description:
 */
public class BaseDaoTest {
//    BaseDao baseDao = new BaseDao();
//    Connection connection = null;
//    PreparedStatement statement = null;
//    ResultSet resultSet = null;

//    @Test
//    public void testInsert() {
//        try{
//            connection = baseDao.getConnection();
//            String sql = "INSERT INTO user(username,password) VALUES(?,?)";
//            statement = connection.prepareStatement(sql);
//            statement.setString(1,"test4");
//            statement.setString(2,DigestUtils.md5Hex("123"));
//            int influenceRows = statement.executeUpdate();
//            Assert.assertEquals(1,influenceRows);
//        }catch (SQLException e){
//            System.err.println("插入失败");
//        }finally {
//            baseDao.closeResources(connection,statement);
//        }
//    }
//
//    @Test
//    public void testDelete(){
//        try {
//            connection = baseDao.getConnection();
//            String sql = "DELETE FROM user WHERE id = ?";
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1,7);
//            int influenceRows = statement.executeUpdate();
//            Assert.assertEquals(1,influenceRows);
//        }catch (SQLException e){
//            System.err.println("删除失败");
//        }finally {
//            baseDao.closeResources(connection,statement);
//        }
//    }
//
//    @Test
//    public void testModify(){
////        try{
////
////        }catch (SQLException e){
////
////        }
//    }

    @Test
    public void testQuery(){
        BaseDao baseDao = new BaseDao();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = baseDao.getConnection();
            String sql = "SELECT * FROM user WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,1);
            resultSet = statement.executeQuery();
            while (resultSet != null){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("id为"+id+",用户名为"+userName+",密码为"+password);
            }
        }catch (SQLException e){
            System.err.println("查询失败");
        }finally {
            baseDao.closeResources(connection,statement,resultSet);
        }
    }
}