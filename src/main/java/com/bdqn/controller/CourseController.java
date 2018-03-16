package com.bdqn.controller;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.services.CourseServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cai on 2018/3/9.
 */
@Controller
@RequestMapping("course")
public class CourseController {
    @Resource
    private CourseServices courseServices;


    @ResponseBody
    @RequestMapping(value = "queryAllCourse", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAllCourse() {
        return JSONArray.toJSONString(courseServices.queryAll());
    }

}
