package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.entity.Student;
import com.bdqn.services.StudentServices;
import com.bdqn.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cai on 2018/2/5.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentServices studentServices;

    @RequestMapping("toStudent")
    public String toStudent(int pageNum, int pageSize, Map map) {
        PageInfo<Student> pageInfo = studentServices.queryAll(pageNum, pageSize);
        map.put("pageInfo", pageInfo);
        return "student";
    }

    @ResponseBody
    @RequestMapping(value = "queryAllStudentByGradeId", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAllStudentByGradeId(Integer gradeId) {
        return JSONArray.toJSONString(studentServices.queryAllStudentByGradeId(gradeId));
    }

    @ResponseBody
    @RequestMapping(value = "deleteStudent", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String deleteStudent(String id) {
        System.out.println(id);
        String[] ids = id.split(",");
        List<Integer> list = new ArrayList<>();
        if (ids != null) {
            for (String s:ids){
                list.add(Integer.parseInt(s));
            }
        }
        int n = studentServices.deleteStudent(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "addStudent", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String addStudent(Student student) {
        int n = studentServices.addStudent(student);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "queryAllStudentById", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAllStudentById(int id) {
        return JSON.toJSONString(studentServices.queryAllStudentById(id));
    }

    @ResponseBody
    @RequestMapping(value = "updateStudent", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateStudent(Student student) {
        int n = studentServices.updateStudent(student);
        System.out.println(student);
        System.out.println(n);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }






























}
