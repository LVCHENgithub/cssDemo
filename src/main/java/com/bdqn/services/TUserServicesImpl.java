package com.bdqn.services;

import com.bdqn.dao.TUserMapper;
import com.bdqn.entity.TUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/2/2.
 */
@Service("userServices")
public class TUserServicesImpl implements TUserServices {
    @Resource
    private TUserMapper tUserMapper;

    @Override
    public TUser loginUser(TUser tUser) {
        return tUserMapper.loginUser(tUser);
    }

    @Override
    public PageInfo<TUser> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TUser> list = tUserMapper.queryAll();
        PageInfo<TUser> painter = new PageInfo<TUser>(list);
        return painter;
    }
}
