package com.bdqn.dao;

/**
 * Created by cai on 2018/2/28.
 */
public interface StudentNumMapper {
    int addStudentNum(int id);

    int updateMaxNumByGradeId(int id);

    int queryMaxNumByGradeId(int id);
}
