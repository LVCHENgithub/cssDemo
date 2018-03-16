package com.bdqn.dao;

import com.bdqn.entity.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cai on 2018/3/7.
 */
public interface ScoreMapper {
    List<Score> queryAll();

    List<Score> queryAllByGradeIdAndStudentId(@Param("gradeId") Integer gradeId,@Param("studentId") Integer studentId);

    int addScore(Score score);
}
