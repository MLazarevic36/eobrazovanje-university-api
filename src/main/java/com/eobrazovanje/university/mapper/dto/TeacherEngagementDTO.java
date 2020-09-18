package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Teacher_role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

public class TeacherEngagementDTO implements Serializable {

    private Long teacher_engagement_id;
    private CourseDTO course;
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teacher_id")
//    @JsonIdentityReference(alwaysAsId = true)
//    @JsonBackReference
    private TeacherDTO teacher;
    private Teacher_role teacher_role;
    private Boolean deleted;

    public TeacherEngagementDTO() {
    }

    public TeacherEngagementDTO(Long teacher_engagement_id, CourseDTO course, TeacherDTO teacher,
                                Teacher_role teacher_role, Boolean deleted) {
        this.teacher_engagement_id = teacher_engagement_id;
        this.course = course;
        this.teacher = teacher;
        this.teacher_role = teacher_role;
        this.deleted = deleted;
    }

    public Long getTeacher_engagement_id() {
        return teacher_engagement_id;
    }

    public void setTeacher_engagement_id(Long teacher_engagement_id) {
        this.teacher_engagement_id = teacher_engagement_id;
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
