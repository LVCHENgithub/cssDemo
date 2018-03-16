package com.bdqn.services;

import com.bdqn.entity.Score;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ScoreServicesImplTest {
    @Test
    public void queryAllByGradeIdAndStudentId() throws Exception {
        PageInfo<Score> pageInfo = scoreServices.queryAllByGradeIdAndStudentId(1, 2, 1, 3);
        List<Score> list = pageInfo.getList();
        if (list != null) {
            for (Object o : list) {
                System.out.println(o);
            }
        }
    }

    @Resource
    private ScoreServices scoreServices;
    @Test
    public void queryAll() throws Exception {
        PageInfo<Score> pageInfo = scoreServices.queryAll(1, 3);
        List<Score> list = pageInfo.getList();
        if (list != null) {
            for (Object o : list) {
                System.out.println(o);

            }
        }
    }

}