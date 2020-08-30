package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.TermName;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TermDTO implements Serializable {

    private Long id;
    private TermName termName;
    private Date start_date;
    private Date end_date;
    private double price;
    private Set<ExamDTO> exams = new HashSet<ExamDTO>();
    private Set<ExamRegistrationDTO> examRegistrations = new HashSet<ExamRegistrationDTO>();
    private Boolean deleted;

    public TermDTO() {
    }

    public TermDTO(Long id, TermName termName, Date start_date, Date end_date, double price, Set<ExamDTO> exams,
                   Set<ExamRegistrationDTO> examRegistrations, Boolean deleted) {
        this.id = id;
        this.termName = termName;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
        this.exams = exams;
        this.examRegistrations = examRegistrations;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TermName getTermName() {
        return termName;
    }

    public void setTermName(TermName termName) {
        this.termName = termName;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<ExamDTO> getExams() {
        return exams;
    }

    public void setExams(Set<ExamDTO> exams) {
        this.exams = exams;
    }

    public Set<ExamRegistrationDTO> getExamRegistrations() {
        return examRegistrations;
    }

    public void setExamRegistrations(Set<ExamRegistrationDTO> examRegistrations) {
        this.examRegistrations = examRegistrations;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
