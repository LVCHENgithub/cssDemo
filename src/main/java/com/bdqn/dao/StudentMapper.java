package com.bdqn.dao;

import com.bdqn.entity.Student;

import java.util.List;

/**
 * Created by cai on 2018/2/5.
 */
public interface StudentMapper {
    List<Student> queryAll();

    int deleteStudent(List<Integer> id);

    int addStudent(Student student);

    int updateStudent(Student student);

    Student queryAllStudentById(int id);

    int addStudentByStudentNum(Student student);

    List<Student> queryAllStudentByGradeId(Integer gradeId);
}
