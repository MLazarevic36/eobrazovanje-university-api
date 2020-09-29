package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Status;

import java.io.Serializable;

public class ExamRegistrationDTO implements Serializable {

    private Long id;
    private int colloquium_points;
    private int exam_points;
    private int grade;
    private Status status;
    private ExamDTO exam;
    private StudentDTO student;
    private Boolean registered;
    private Boolean deleted;

    public ExamRegistrationDTO() {
    }

    public ExamRegistrationDTO(Long id, int colloquium_points, int exam_points, int grade, Status status,
                               ExamDTO exam, StudentDTO student, Boolean registered, Boolean deleted) {
        this.id = id;
        this.colloquium_points = colloquium_points;
        this.exam_points = exam_points;
        this.grade = grade;
        this.status = status;
        this.exam = exam;
        this.student = student;
        this.registered = registered;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getColloquium_points() {
        return colloquium_points;
    }

    public void setColloquium_points(int colloquium_points) {
        this.colloquium_points = colloquium_points;
    }

    public int getExam_points() {
        return exam_points;
    }

    public void setExam_points(int exam_points) {
        this.exam_points = exam_points;
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

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}
