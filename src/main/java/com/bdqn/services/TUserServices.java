package com.bdqn.services;

import com.bdqn.entity.TUser;
import com.github.pagehelper.PageInfo;

/**
 * Created by cai on 2018/2/2.
 */
public interface TUserServices {
    TUser loginUser(TUser tUser);

    PageInfo<TUser> queryAll(int pageNum, int pageSize);
}
