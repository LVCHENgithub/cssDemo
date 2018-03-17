package com.bdqn.services;

import com.bdqn.entity.TUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cai on 2018/2/2.
 */
public class TUserServicesTest {
    @Test
    public void loginUser() throws Exception {
        System.out.println("2");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TUserServices services = (TUserServices) context.getBean("userServices");
        TUser tUser = services.loginUser(new TUser(0, "admin", "1231", ""));
        if (tUser != null) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

}