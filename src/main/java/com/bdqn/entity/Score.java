package com.bdqn.entity;

/**
 * Created by cai on 2018/3/7.
 */
public class Score {
    private Integer id;
    private Student student;
    private Course course;
    private Double score;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Score(Integer id, Student student, Course course, Double score) {

        this.id = id;
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public Score() {

    }
}
