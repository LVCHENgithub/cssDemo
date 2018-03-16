package com.bdqn.entity;

import java.util.Date;

/**
 * Created by cai on 2018/3/5.
 */
public class Hobby {
    private int id;
    private String hobbyName;
    private Date createTime;

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", hobbyName='" + hobbyName + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Hobby(int id, String hobbyName) {
        this.id = id;
        this.hobbyName = hobbyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Hobby(int id, String hobbyName, Date createTime) {

        this.id = id;
        this.hobbyName = hobbyName;
        this.createTime = createTime;
    }

    public Hobby() {

    }
}
