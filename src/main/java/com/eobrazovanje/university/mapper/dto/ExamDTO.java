package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Status;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ExamDTO implements Serializable {

    private Long id;
    private CourseEnrollmentDTO courseEnrollmentDTO;
    private int grade;
    private Status status;
    private StudentDTO studentDTO;
    private Set<ColloquiumDTO> colloquiumDTOS = new HashSet<>();
    private Boolean deleted;

    public ExamDTO() {
    }

    public ExamDTO(Long id, CourseEnrollmentDTO courseEnrollmentDTO, int grade, Status status, StudentDTO studentDTO,
                   Set<ColloquiumDTO> colloquiumDTOS, Boolean deleted) {
        this.id = id;
        this.courseEnrollmentDTO = courseEnrollmentDTO;
        this.grade = grade;
        this.status = status;
        this.studentDTO = studentDTO;
        this.colloquiumDTOS = colloquiumDTOS;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseEnrollmentDTO getCourseEnrollmentDTO() {
        return courseEnrollmentDTO;
    }

    public void setCourseEnrollmentDTO(CourseEnrollmentDTO courseEnrollmentDTO) {
        this.courseEnrollmentDTO = courseEnrollmentDTO;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public Set<ColloquiumDTO> getColloquiumDTOS() {
        return colloquiumDTOS;
    }

    public void setColloquiumDTOS(Set<ColloquiumDTO> colloquiumDTOS) {
        this.colloquiumDTOS = colloquiumDTOS;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
