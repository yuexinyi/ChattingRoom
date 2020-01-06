package com.bittech.java.chatroom.utils;

import com.bittech.java.chatroom.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommUtilsTest {

    @Test
    public void loadProperties() {
        String fileName = "datasource.properties";
        Properties properties = CommUtils.loadProperties(fileName);
        System.out.println(properties);
        String url = properties.getProperty("url");
        //url不为空,断言测试成功
        Assert.assertNotNull(url);
        //url = null,url不为空，断言测试失败
        //Assert.assertEquals(null,url);
    }

    @Test
    public void gsonTest1(){
        User user = new User();
        user.setId(10);
        user.setUserName("testyxy");
        user.setPassword("123");
        String jsonStr = CommUtils.object2Json(user);
        System.out.println(jsonStr);
    }

    @Test
    public void gsonTest2(){
        String jsonStr = "{\"id\":10,\"userName\":\"testyxy\",\"password\":\"123\"}";
        Object user = CommUtils.json2Object(jsonStr,User.class);
        System.out.println(user);
    }
}