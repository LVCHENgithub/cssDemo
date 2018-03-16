package com.bdqn.services;

import com.bdqn.entity.Grade;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/2/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GradeServicesImplTest {
    @Test
    public void addGradeByStudentNum() throws Exception {
        Grade grade = new Grade();
        grade.setGradeName("tcmp064");
        grade.setDetails("班级名称");
        System.out.println(gradeServices.addGradeByStudentNum(grade));
    }

    @Test
    public void updateGrade() throws Exception {
        Grade grade = new Grade();
        grade.setId(26);
        grade.setDetails("2222");
        System.out.println(gradeServices.updateGrade(grade));
    }

    @Test
    public void detailGrade() throws Exception {
        System.out.println(gradeServices.detailGrade(1));
    }

    @Resource
    private GradeServices gradeServices;
    @Test
    public void queryAll() throws Exception {
        PageInfo<Grade> pageInfo = gradeServices.queryAll(1, 2);
        List<Grade> list = pageInfo.getList();
        if (list != null) {
            for (Object o : list) {
                System.out.println(o);
            }
        }
    }

}