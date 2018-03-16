package com.bdqn.services;

import com.bdqn.dao.StudentNumMapper;
import com.bdqn.entity.Grade;
import com.bdqn.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServicesImplTest {
    @Test
    public void queryAllStudentByGradeId() throws Exception {
        List<Student> list = studentServices.queryAllStudentByGradeId(1);
        if (list != null) {
            for (Object o : list) {
                System.out.println(o);
            }
        }
    }

    @Test
    public void addStudentByStudentNum() throws Exception {
        Student student = new Student();
        Grade grade = new Grade();
        grade.setId(116);
        grade.setGradeName("tcmp064");
        student.setGrade(grade);
        student.setStudentName("321");
        student.setAge(12);
        student.setGender("男");
        System.out.println(studentServices.addStudentByStudentNum(student));

    }

    @Test
    public void updateStudent() throws Exception {
        Student student = new Student();
        student.setStudentName("1");
        Grade grade = new Grade();
        grade.setId(1);
        student.setGrade(grade);
        student.setGender("aa");
        student.setAge(12);
        student.setId(1);

        System.out.println(studentServices.updateStudent(student));
    }

    @Test
    public void queryAllStudentById() throws Exception {
        System.out.println(studentServices.queryAllStudentById(1));
    }

    @Test
    public void addStudent() throws Exception {
        Student student = new Student();
        Grade grade = new Grade();
        grade.setId(1);
        student.setAge(19);
        student.setGender("na");
        student.setGrade(grade);
        student.setStudentName("xuesheng");
        student.setStudentNum("111");

        System.out.println(studentServices.addStudent(student));
    }

    @Test
    public void queryAll1() throws Exception {
        for (Student student : studentServices.queryAll(1, 3).getList()) {
            System.out.println(student);
        }
    }

    @Resource
    private StudentNumMapper studentNumMapper;

    @Resource
    private StudentServices studentServices;


}