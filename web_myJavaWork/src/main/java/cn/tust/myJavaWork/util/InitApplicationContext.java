package cn.tust.myJavaWork.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Liyutian
 * @Date:Create：in 2020/11/23 0:54
 */
public class InitApplicationContext {
    public static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
