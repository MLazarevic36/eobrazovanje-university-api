package com.eobrazovanje.university.mapper.dto;

public class CourseEnrollmentWIthIndexDTO {

    private Long id;
    private CourseDTO course;
    private String index_number;
    private Boolean deleted;

    public CourseEnrollmentWIthIndexDTO(Long id, CourseDTO course, String index_number, Boolean deleted) {
        this.id = id;
        this.course = course;
        this.index_number = index_number;
        this.deleted = deleted;
    }

    public CourseEnrollmentWIthIndexDTO() {
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

    public String getIndex_number() {
        return index_number;
    }

    public void setIndex_number(String index_number) {
        this.index_number = index_number;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
