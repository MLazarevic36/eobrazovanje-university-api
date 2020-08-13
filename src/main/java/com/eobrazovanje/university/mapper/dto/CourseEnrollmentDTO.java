package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;

public class CourseEnrollmentDTO implements Serializable {

    private Long id;
    private CourseDTO courseDTO;
    private StudentDTO studentDTO;
    private Boolean deleted;

    public CourseEnrollmentDTO() {
    }

    public CourseEnrollmentDTO(Long id, CourseDTO courseDTO, StudentDTO studentDTO, Boolean deleted) {
        this.id = id;
        this.courseDTO = courseDTO;
        this.studentDTO = studentDTO;
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

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
