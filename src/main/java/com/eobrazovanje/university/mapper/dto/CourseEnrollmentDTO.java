package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;

public class CourseEnrollmentDTO implements Serializable {

    private Long id;
    private CourseDTO course;
    private StudentDTO student;
    private Boolean deleted;

    public CourseEnrollmentDTO() {
    }

    public CourseEnrollmentDTO(Long id, CourseDTO course, StudentDTO student, Boolean deleted) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
