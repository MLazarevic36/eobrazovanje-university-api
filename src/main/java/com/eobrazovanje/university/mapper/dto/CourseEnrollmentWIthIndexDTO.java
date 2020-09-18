package com.eobrazovanje.university.mapper.dto;

public class CourseEnrollmentWIthIndexDTO {

    private Long course_enrollment_id;
    private CourseDTO course;
    private String index_number;
    private Boolean deleted;

    public CourseEnrollmentWIthIndexDTO(Long course_enrollment_id, CourseDTO course, String index_number, Boolean deleted) {
        this.course_enrollment_id = course_enrollment_id;
        this.course = course;
        this.index_number = index_number;
        this.deleted = deleted;
    }

    public CourseEnrollmentWIthIndexDTO() {
    }

    public Long getCourse_enrollment_id() {
        return course_enrollment_id;
    }

    public void setCourse_enrollment_id(Long course_enrollment_id) {
        this.course_enrollment_id = course_enrollment_id;
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
