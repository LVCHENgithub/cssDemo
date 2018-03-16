package com.bdqn.services;

import com.bdqn.dao.CourseMapper;
import com.bdqn.entity.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/3/9.
 */
@Service("courseServices")
public class CourseServicesImpl implements CourseServices {
    @Resource
    private CourseMapper courseMapper;
    @Override
    public List<Course> queryAll() {
        return courseMapper.queryAll();
    }
}
