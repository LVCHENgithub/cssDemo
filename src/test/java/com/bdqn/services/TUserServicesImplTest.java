package com.bdqn.services;

import com.bdqn.entity.TUser;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/2/2.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TUserServicesImplTest {
    @Resource
    private TUserServices services;
    @Test
    public void queryAll() throws Exception {
        PageInfo<TUser> pageInfo = services.queryAll(1, 3);
        System.out.println(pageInfo);
        List<TUser> list = pageInfo.getList();
        if (list != null) {
            System.out.println(pageInfo);
            for (Object o : list) {
                System.out.println(o);
            }
        }


    }

    @Test
    public void loginUser() throws Exception {
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