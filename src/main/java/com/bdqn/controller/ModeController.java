package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cai on 2018/3/5.
 */
@Controller
@RequestMapping("mode")
public class ModeController {

    @RequestMapping("toMode")
    public String toMode() {
        return "mode";
    }
}
