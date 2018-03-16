package com.bdqn.controller;

import com.bdqn.entity.TUser;
import com.bdqn.services.TUserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by cai on 2018/2/2.
 */
@Controller
public class IndexController {
    @Resource
    private TUserServices services;

    @RequestMapping("main")
    public String loginMain(TUser tUser, HttpSession session, Model model) {
        TUser loginUser = services.loginUser(tUser);
        if (null!=loginUser){
            session.setAttribute("tUser",loginUser);
            model.addAttribute("message", "登录成功");
            return "main";
        }else{
            model.addAttribute("message", "用户名或密码错误");
            return "index1";

        }
    }

    @RequestMapping("welcome")
    public String loginController(TUser tUser, HttpSession session, Model model) {
        TUser loginUser = services.loginUser(tUser);
        if (null!=loginUser){
            session.setAttribute("tUser",loginUser);
            model.addAttribute("message", "登录成功");
            return "welcome";
        }else{
            model.addAttribute("message", "用户名或密码错误");
            return "index";

        }
    }

    @RequestMapping("logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("tUser");
        return "index";
    }
}
