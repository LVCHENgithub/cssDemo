package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Score;
import com.bdqn.services.ScoreServices;
import com.bdqn.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cai on 2018/3/3.
 */
@Controller
@RequestMapping("score")
public class ScoreController {
    @Resource
    private ScoreServices scoreServices;

    @RequestMapping("toScore")
    public String toScore() {
        return "score";
    }

    @ResponseBody
    @RequestMapping(value = "queryScoreAll",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryScoreByGradeIdAndStudentId(Integer gradeId, Integer studentId, Integer page, Integer rows) {
        if (gradeId!=null&&gradeId==-1){
            gradeId = null;
        }
        if (studentId != null && studentId == -1) {
            studentId=null;
        }
        return JSON.toJSONString(new PageUtil<Score>(scoreServices.queryAllByGradeIdAndStudentId(gradeId, studentId, page, rows)));
    }

    @ResponseBody
    @RequestMapping(value = "queryScoreAll1",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryScoreAll(int page,int rows){
        PageInfo<Score> pageInfo = scoreServices.queryAll(page, rows);
        return JSON.toJSONString(new PageUtil<Score>(pageInfo));

    }

}
