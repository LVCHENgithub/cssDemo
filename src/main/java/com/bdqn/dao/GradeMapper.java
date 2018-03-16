package com.bdqn.dao;

import com.bdqn.entity.Grade;

import java.util.List;

/**
 * Created by cai on 2018/2/5.
 */
public interface GradeMapper {
    List<Grade> queryAll();

    Grade detailGrade(int id);

    Integer deleteGradeById(Integer id);

    Integer deleteGradeByIds(List<Integer> ids);

    int addGrade(Grade grade);

    int updateGrade(Grade grade);

    int addGradeByStudentNum(Grade grade);

}
