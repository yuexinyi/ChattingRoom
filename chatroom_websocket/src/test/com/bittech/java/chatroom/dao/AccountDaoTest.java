package com.bittech.java.chatroom.dao;

import com.bittech.java.chatroom.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author:Star
 * @Date:Created in 10:27 2019/8/3
 * @Description:
 */
public class AccountDaoTest {
    AccountDao accountDao = new AccountDao();

    @Test
    public void userRegister() {
        User user = new User();
        user.setUserName("testyxy");
        user.setPassword("123");
        boolean isSuccess = accountDao.userRegister(user);
        Assert.assertEquals(true,isSuccess);
    }

    @Test
    public void userLogin() {
        User user = accountDao.userLogin("testyxy","123");
        System.out.println(user);
        Assert.assertNotNull(user);
    }
}