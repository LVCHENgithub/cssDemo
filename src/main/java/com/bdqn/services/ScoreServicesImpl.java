package com.bdqn.services;

import com.bdqn.dao.ScoreMapper;
import com.bdqn.entity.Score;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cai on 2018/3/7.
 */
@Service("scoreServices")
public class ScoreServicesImpl implements ScoreServices {
    @Resource
    private ScoreMapper scoreMapper;
    @Override
    public PageInfo<Score> queryAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(scoreMapper.queryAll());
    }

    @Override
    public PageInfo<Score> queryAllByGradeIdAndStudentId(Integer gradeid, Integer studentId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(scoreMapper.queryAllByGradeIdAndStudentId(gradeid, studentId));
    }

}
