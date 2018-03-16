package com.bdqn.services;

import com.bdqn.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CourseServicesImplTest {
    @Resource
    private CourseServices courseServices;
    @Test
    public void queryAll() throws Exception {
        List<Course> list = courseServices.queryAll();
        if (list != null) {
            for (Object o : list) {
                System.out.println(o);
            }
        }
    }

}