package com.eobrazovanje.university.mapper.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

public class CourseEnrollmentDTO implements Serializable {

    private Long course_enrollment_id;
    private CourseDTO course;
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "student_id")
//    @JsonIdentityReference(alwaysAsId = true)
//    @JsonBackReference(value = "student-enrollments")
    private StudentDTO student;
    private Boolean deleted;

    public CourseEnrollmentDTO() {
    }

    public CourseEnrollmentDTO(Long course_enrollment_id, CourseDTO course, StudentDTO student, Boolean deleted) {
        this.course_enrollment_id = course_enrollment_id;
        this.course = course;
        this.student = student;
        this.deleted = deleted;
    }

    public Long getCourse_enrollment_id() {
        return course_enrollment_id;
    }

    public void setCourse_enrollment_id(Long course_enrollment_id) {
        this.course_enrollment_id = course_enrollment_id;
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
