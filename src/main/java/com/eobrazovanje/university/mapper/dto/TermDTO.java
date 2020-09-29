package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.TermName;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TermDTO implements Serializable {

    private Long id;
    private TermName term_name;
    private Date start_date;
    private Date end_date;
    private Set<ExamDTO> exams = new HashSet<ExamDTO>();

    private Boolean deleted;

    public TermDTO() {
    }

    public TermDTO(Long id, TermName term_name, Date start_date, Date end_date, Set<ExamDTO> exams,
                   Boolean deleted) {
        this.id = id;
        this.term_name = term_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.exams = exams;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TermName getTerm_name() {
        return term_name;
    }

    public void setTerm_name(TermName term_name) {
        this.term_name = term_name;
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

    public Set<ExamDTO> getExams() {
        return exams;
    }

    public void setExams(Set<ExamDTO> exams) {
        this.exams = exams;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
