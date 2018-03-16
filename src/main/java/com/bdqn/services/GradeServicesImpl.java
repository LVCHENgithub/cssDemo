package com.bdqn.services;

import com.bdqn.dao.GradeMapper;
import com.bdqn.dao.StudentNumMapper;
import com.bdqn.entity.Grade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/2/5.
 */
@Service("gradeServices")
public class GradeServicesImpl implements GradeServices {
    @Resource
    private GradeMapper gradeMapper;

    @Resource
    private StudentNumMapper studentNumMapper;


    @Override
    public PageInfo<Grade> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Grade> list = gradeMapper.queryAll();
        PageInfo<Grade> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Grade detailGrade(int id) {
        return gradeMapper.detailGrade(id);
    }

    @Override
    public Integer deleteGradeById(Integer id) {
        return gradeMapper.deleteGradeById(id);
    }

    @Override
    public Integer deleteGradeByIds(List<Integer> ids) {
        return gradeMapper.deleteGradeByIds(ids);
    }

    @Override
    public int addGrade(Grade grade) {
        return gradeMapper.addGrade(grade);
    }

    @Override
    public int updateGrade(Grade grade) {
        return gradeMapper.updateGrade(grade);
    }

    @Override
    public List<Grade> queryAll() {
        return gradeMapper.queryAll();
    }

    @Override
    public int addGradeByStudentNum(Grade grade) {
        gradeMapper.addGradeByStudentNum(grade);
        return studentNumMapper.addStudentNum(grade.getId());
    }
}
