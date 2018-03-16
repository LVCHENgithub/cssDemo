package com.bdqn.dao;

import com.bdqn.entity.Course;

import java.util.List;

/**
 * Created by cai on 2018/3/9.
 */
public interface CourseMapper {
    List<Course> queryAll();
}
