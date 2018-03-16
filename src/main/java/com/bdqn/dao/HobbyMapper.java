package com.bdqn.dao;

import com.bdqn.entity.Hobby;

import java.util.List;

/**
 * Created by cai on 2018/3/5.
 */
public interface HobbyMapper {
    List<Hobby> queryAll();

    int addHobby(Hobby hobby);

    int deleteHobby(int id);

    int deleteHobbyByIds(List<Integer> ids);

    Hobby detailHobbyById(int id);

    int updateHobby(Hobby hobby);
}
