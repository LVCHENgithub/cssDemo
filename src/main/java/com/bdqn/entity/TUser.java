package com.bdqn.entity;

/**
 * Created by cai on 2018/2/2.
 */
public class TUser {
    private int id;
    private String userName,password,nickName;

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public TUser(int id, String userName, String password, String nickName) {

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }

    public TUser() {

    }
}
