package com.bdqn.services;

import com.bdqn.dao.StudentMapper;
import com.bdqn.dao.StudentNumMapper;
import com.bdqn.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/2/15.
 */
@Service("studentServices")
public class StudentServicesImpl implements StudentServices {
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentNumMapper studentNumMapper;

    @Override
    public PageInfo<Student> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(studentMapper.queryAll());
    }

    @Override
    public int deleteStudent(List<Integer> id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public Student queryAllStudentById(int id) {
        return studentMapper.queryAllStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int addStudentByStudentNum(Student student) {
        int gradeId = student.getGrade().getId();
        studentNumMapper.updateMaxNumByGradeId(gradeId);
        int Max = studentNumMapper.queryMaxNumByGradeId(gradeId);
        String GradeName = student.getGrade().getGradeName();
        String StudentNum = GradeName+Max;
        int n = 15-StudentNum.length();
        for (int i = 0;i<n;i++) {
            GradeName = GradeName+0;
        }
        StudentNum = GradeName+Max;
        student.setStudentNum(StudentNum);

        return studentMapper.addStudent(student);
    }

    @Override
    public List<Student> queryAllStudentByGradeId(Integer gradeId) {
        return studentMapper.queryAllStudentByGradeId(gradeId);
    }

}
