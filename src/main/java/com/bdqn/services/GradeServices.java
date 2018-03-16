package com.bdqn.services;

import com.bdqn.entity.Grade;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by cai on 2018/2/5.
 */

public interface GradeServices {
    PageInfo<Grade> queryAll(int pageNum, int pageSize);

    Grade detailGrade(int id);

    Integer deleteGradeById(Integer id);

    Integer deleteGradeByIds(List<Integer> ids);

    int addGrade(Grade grade);

    int updateGrade(Grade grade);

    List<Grade> queryAll();

    int addGradeByStudentNum(Grade grade);

}
