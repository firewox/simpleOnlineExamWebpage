package com;

import cn.tust.myJavaWork.dao.impl.UserDaoImpl;
import cn.tust.myJavaWork.domain.User;
import cn.tust.myJavaWork.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUser {
    @Autowired
    private LoginServiceImpl service;

    @Test
    public void register(){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
    }
}
