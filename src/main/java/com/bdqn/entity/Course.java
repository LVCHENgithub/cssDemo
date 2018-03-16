package com.bdqn.entity;

/**
 * Created by cai on 2018/3/7.
 */
public class Course {
    private int id;
    private String courseName;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course(int id, String courseName) {

        this.id = id;
        this.courseName = courseName;
    }

    public Course() {

    }
}
