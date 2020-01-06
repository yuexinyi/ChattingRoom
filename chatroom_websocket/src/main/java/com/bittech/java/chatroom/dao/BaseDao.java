package com.bittech.java.chatroom.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bittech.java.chatroom.utils.CommUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: star
 * @Date: 2019-08-03 09:52
 * @Description:封装基础操作,数据源、获取连接、关闭资源
 */
public class BaseDao {
    private static DataSource dataSource;
    //加载数据源，是全局唯一，放到static代码块中在类加载时只加载一次
    static {
        Properties properties = CommUtils.
                loadProperties("datasource.properties");
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.err.println("数据源加载失败");
        }
    }

    // 获取数据库连接（每个用户都会获取）
    protected Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("获取连接失败");
        }
        return null;
    }

    // 关闭资源Statement ResultSet Connection
    // 对于数据库更新，删除，修改无返回结果集，只需要关闭连接和执行SQL资源
    protected void closeResources(Connection connection,
                                  Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //对于数据库查询，返回结果集，则需要多关闭结果集资源
    protected void closeResources(Connection connection,
                                  Statement statement,
                                  ResultSet resultSet) {
        closeResources(connection,statement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
