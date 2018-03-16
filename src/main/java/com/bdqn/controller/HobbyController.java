package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Hobby;
import com.bdqn.services.HobbyServices;
import com.bdqn.util.Message;
import com.bdqn.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cai on 2018/3/3.
 */
@Controller
@RequestMapping("hobby")
public class HobbyController {

    @Resource
    private HobbyServices hobbyServices;

    @RequestMapping("toHobby")
    public String toHobby() {
        return "hobby";
    }

    @ResponseBody
    @RequestMapping(value = "queryAll", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAll(int page, int rows) {
        PageInfo<Hobby> pageInfo = hobbyServices.queryAll(page, rows);
        PageUtil<Hobby> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "addHobby", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String addHobby(Hobby hobby) {
        int n = hobbyServices.addHobby(hobby);
        return print(n);
    }

    private String print(int n) {
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }else {
            return JSON.toJSONString(Message.error());
        }
    }

    @ResponseBody
    @RequestMapping(value = "deleteHobby", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String deleteHobby(int id) {
        int n = hobbyServices.deleteHobby(id);
        return print(n);
    }

    @ResponseBody
    @RequestMapping(value = "deleteHobbyByIds",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String deleteHobbyByIds(String ids){
        String[] id = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (id!=null){
            for (String s : id) {
                list.add(Integer.parseInt(s));
            }
        }
        int n = hobbyServices.deleteHobbyByIds(list);
        return print(n);
    }

    @ResponseBody
    @RequestMapping(value = "detailHobbyById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String detailHobbyById(int id) {
        return JSON.toJSONString(hobbyServices.detailHobbyById(id));
    }

    @ResponseBody
    @RequestMapping(value = "updateHobbyById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateHobbyById(Hobby hobby) {
        int n = hobbyServices.updateHobby(hobby);
        return print(n);
    }
}
