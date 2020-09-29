package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Teacher_role;

import java.io.Serializable;

public class TeacherEngagementDTO implements Serializable {

    private Long id;
    private CourseDTO course;
    private TeacherDTO teacher;
    private Teacher_role teacher_role;
    private Boolean deleted;

    public TeacherEngagementDTO() {
    }

    public TeacherEngagementDTO(Long id, CourseDTO course, TeacherDTO teacher,
                                Teacher_role teacher_role, Boolean deleted) {
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.teacher_role = teacher_role;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public Teacher_role getTeacher_role() {
        return teacher_role;
    }

    public void setTeacher_role(Teacher_role teacher_role) {
        this.teacher_role = teacher_role;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
