package com.bdqn.services;

import com.bdqn.entity.Score;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by cai on 2018/3/7.
 */
public interface ScoreServices {
    PageInfo<Score> queryAll(int pageNum,int pageSize);

    PageInfo<Score> queryAllByGradeIdAndStudentId(@Param("gradeId") Integer gradeid, @Param("studentId") Integer studentId,int pageNum,int pageSize);
}
