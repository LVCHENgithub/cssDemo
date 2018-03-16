package com.bdqn.services;

import com.bdqn.dao.HobbyMapper;
import com.bdqn.entity.Hobby;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cai on 2018/3/5.
 */
@Service("hobbyServices")
public class HobbyServicesImpl implements HobbyServices {
    @Resource
    private HobbyMapper hobbyMapper;
    @Override
    public PageInfo<Hobby> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(hobbyMapper.queryAll());
    }

    @Override
    public int addHobby(Hobby hobby) {
        return hobbyMapper.addHobby(hobby);
    }

    @Override
    public int deleteHobby(int id) {
        return hobbyMapper.deleteHobby(id);
    }

    @Override
    public int deleteHobbyByIds(List<Integer> ids) {
        return hobbyMapper.deleteHobbyByIds(ids);
    }

    @Override
    public Hobby detailHobbyById(int id) {
        return hobbyMapper.detailHobbyById(id);
    }

    @Override
    public int updateHobby(Hobby hobby) {
        return hobbyMapper.updateHobby(hobby);
    }
}
