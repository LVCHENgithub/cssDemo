package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.entity.Grade;
import com.bdqn.services.GradeServices;
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
@RequestMapping("grade")
public class GradeController {
    @Resource
    private GradeServices gradeServices;
    @RequestMapping("toGrade")
    public String toGrade(int pageNum, int pageSize, Map map) {
        PageInfo<Grade> pageInfo = gradeServices.queryAll(pageNum,pageSize);
        map.put("pageInfo", pageInfo);
        return "grade";
    }

    @ResponseBody
    @RequestMapping(value = "queryAllGrade", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAllGrade() {
        return JSONArray.toJSONString(gradeServices.queryAll());
    }

    @ResponseBody
    @RequestMapping(value = "detailGrade", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String detailGrade(int id) {

        return JSON.toJSONString(gradeServices.detailGrade(id));
    }

    @ResponseBody
    @RequestMapping(value = "deleteGradeById",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String deleteGradeById(Integer gradeId) {
        Integer n = gradeServices.deleteGradeById(gradeId);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "deleteGradeByIdArray",method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    public String deleteGradeByIdArray(String ids){
        String[] idsArray=ids.split(",");
        List<Integer> list = new ArrayList<>();
        if(null!=idsArray){
            for (String s : idsArray) {
                list.add(Integer.parseInt(s));
            }
        }
        int n = gradeServices.deleteGradeByIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "addGrade", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String addGrade(Grade grade) {
        int n = gradeServices.addGrade(grade);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "updateGrade", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateGrade(Grade grade) {
        int n = gradeServices.updateGrade(grade);
        System.out.println(grade);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

}





















