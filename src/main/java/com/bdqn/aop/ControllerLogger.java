package com.bdqn.aop;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by cai on 2018/3/2.
 */
public class ControllerLogger {
    private static final Logger logger = Logger.getLogger("ControllerLogger");

    public void before(JoinPoint jp) {
        logger.info("before 调用了:" + jp.getTarget() + "的" + jp.getSignature() + "方法,方法入参" + Arrays.toString(jp.getArgs()));
    }

    public void after(JoinPoint jp,Object result) {
        logger.info("after 调用了:" + jp.getTarget() + "的" + jp.getSignature() + "方法,返回值" + Arrays.toString(jp.getArgs()));
    }
}
