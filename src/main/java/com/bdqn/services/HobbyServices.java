package com.bdqn.services;

import com.bdqn.entity.Hobby;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by cai on 2018/3/5.
 */
public interface HobbyServices {
    PageInfo<Hobby> queryAll(int pageNum, int pageSize);

    int addHobby(Hobby hobby);

    int deleteHobby(int id);

    int deleteHobbyByIds(List<Integer> ids);

    Hobby detailHobbyById(int id);

    int updateHobby(Hobby hobby);
}
