package com.bdqn.services;

import com.bdqn.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by cai on 2018/2/15.
 */

public interface StudentServices {
    PageInfo<Student> queryAll(int pageNum, int pageSize);

    int deleteStudent(List<Integer> id);

    int addStudent(Student student);

    Student queryAllStudentById(int id);

    int updateStudent(Student student);

    int addStudentByStudentNum(Student student);

    List<Student> queryAllStudentByGradeId(Integer gradeId);


}
