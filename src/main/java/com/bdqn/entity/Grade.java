package com.bdqn.entity;

import java.util.Date;

/**
 * Created by cai on 2018/2/5.
 */
public class Grade {
    /*
    id          int(11) NOT NULL班级id
grade_name      varchar(10) NULL班级名称
create_date     date NULL创建时间
details         varchar(500) NULL班级描述
     */
    private int id;
    private String gradeName,details;
    private Date createDate;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                ", details='" + details + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Grade() {

        this.id = id;
        this.gradeName = gradeName;
        this.details = details;
        this.createDate = createDate;
    }

    public Grade(int id, String gradeName, String details, String s) {

    }
}
