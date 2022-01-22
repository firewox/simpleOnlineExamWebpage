package cn.tust.myJavaWork;

import cn.tust.myJavaWork.domain.User;
import cn.tust.myJavaWork.service.ILoginService;
import cn.tust.myJavaWork.service.IRegisterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Liyutian
 * @Date:Create：in 2020/11/22 19:09
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ILoginService service = ac.getBean("loginService", ILoginService.class);
        //登录
        test01(service);
        //注册
        //IRegisterService registerService = ac.getBean("registerService", IRegisterService.class);
        //test02(registerService);
    }
    //登录
    private static void test01(ILoginService service){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("12346");
        service.findUserByUsernameAndPassword(user);
    }

    private static void test02(IRegisterService registerService){
        User user = new User("张三","12346");
        registerService.saveUser(user);
    }
}
