package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Status;

import java.io.Serializable;

public class ExamRegistrationDTO implements Serializable {

    private Long id;
    private int grade;
    private Status status;
    private TermDTO termDTO;
    private ExamDTO examDTO;
    private StudentDTO studentDTO;
    private Boolean registered;
    private Boolean deleted;

    public ExamRegistrationDTO() {
    }

    public ExamRegistrationDTO(Long id, int grade, Status status, TermDTO termDTO, ExamDTO examDTO, StudentDTO studentDTO,
                               Boolean registered, Boolean deleted) {
        this.id = id;
        this.grade = grade;
        this.status = status;
        this.termDTO = termDTO;
        this.examDTO = examDTO;
        this.studentDTO = studentDTO;
        this.registered = registered;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TermDTO getTermDTO() {
        return termDTO;
    }

    public void setTermDTO(TermDTO termDTO) {
        this.termDTO = termDTO;
    }

    public ExamDTO getExamDTO() {
        return examDTO;
    }

    public void setExamDTO(ExamDTO examDTO) {
        this.examDTO = examDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
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
