package com.bdqn.services;

import com.bdqn.entity.Hobby;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cai on 2018/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HobbyServicesImplTest {
    @Test
    public void deleteHobbyByIds() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(44);
        list.add(45);
        list.add(46);
        System.out.println(hobbyServices.deleteHobbyByIds(list));
    }

    @Test
    public void detailHobbyById() throws Exception {
        System.out.println(hobbyServices.detailHobbyById(47));
    }

    @Test
    public void updateHobby() throws Exception {
        System.out.println(hobbyServices.updateHobby(new Hobby(52,"空心球")));
    }

    @Test
    public void deleteHobby() throws Exception {
        System.out.println(hobbyServices.deleteHobby(54));
    }

    @Test
    public void addHobby() throws Exception {
        Hobby hobby = new Hobby();
        hobby.setHobbyName("乒乓球");
        int n = hobbyServices.addHobby(hobby);
        System.out.println(n);
    }

    @Resource
    private HobbyServices hobbyServices;
    @Test
    public void queryAll() throws Exception {
        PageInfo<Hobby> pageInfo = hobbyServices.queryAll(1, 4);
        List<Hobby> list = pageInfo.getList();
        System.out.println(list);
        for (Hobby hobby : list) {
            System.out.println(hobby);
        }
//        if (list != null) {
//            for (Object o : list) {
//                System.out.println(o);
//            }
//        }

    }

}