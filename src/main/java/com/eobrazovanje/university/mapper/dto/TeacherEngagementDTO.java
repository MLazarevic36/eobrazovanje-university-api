package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Teacher_role;

import java.io.Serializable;

public class TeacherEngagementDTO implements Serializable {

    private Long id;
    private CourseDTO courseDTO;
    private TeacherDTO teacherDTO;
    private Teacher_role teacher_role;
    private Boolean deleted;

    public TeacherEngagementDTO() {
    }

    public TeacherEngagementDTO(Long id, CourseDTO courseDTO, TeacherDTO teacherDTO, Teacher_role teacher_role, Boolean deleted) {
        this.id = id;
        this.courseDTO = courseDTO;
        this.teacherDTO = teacherDTO;
        this.teacher_role = teacher_role;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
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
