package com.bdqn.dao;

import com.bdqn.entity.TUser;

import java.util.List;

/**
 * Created by cai on 2018/2/2.
 */
public interface TUserMapper {
    TUser loginUser(TUser tUser);

    List<TUser> queryAll();
}
