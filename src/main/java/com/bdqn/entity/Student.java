package com.bdqn.entity;

/**
 * Created by cai on 2018/2/5.
 */
public class Student {
    /*
    id          int(11) NOT NULL
grade_id        int(11) NULL班级id
student_name    varchar(10) NULL学生姓名
gender          varchar(2) NULL性别
age             int(11) NULL年龄
student_num     varchar(20) NULL学号
     */
    private int id,age;
    private String studentName,gender,studentNum;
    private Grade grade;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student(int id, int age, String studentName, String gender, String studentNum) {
        this.id = id;
        this.age = age;
        this.studentName = studentName;
        this.gender = gender;
        this.studentNum = studentNum;
    }

    public Student(int id, int gradeid, int age, String studentName, String gender, String studentNum, Grade grade) {

        this.id = id;
        this.age = age;
        this.studentName = studentName;
        this.gender = gender;
        this.studentNum = studentNum;
        this.grade = grade;
    }

    public Student() {

    }
}
