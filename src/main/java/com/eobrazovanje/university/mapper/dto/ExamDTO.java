package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.Status;
import com.eobrazovanje.university.entity.Term;
import com.fasterxml.jackson.annotation.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class ExamDTO implements Serializable {

    private Long exam_id;
    private CourseDTO course;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Timestamp date;

    private String location;
    private double price;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "term_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonBackReference(value="term-exams")
    private TermDTO term;
//    @JsonManagedReference(value = "exams-exam-registrations")
    @JsonIgnore
    private Set<ExamRegistrationDTO> examRegistrations = new HashSet<ExamRegistrationDTO>();
    private Boolean deleted;

    public ExamDTO() {
    }

    public ExamDTO(Long exam_id, CourseDTO course, Timestamp date, String location,
                   double price, TermDTO term, Set<ExamRegistrationDTO> examRegistrations, Boolean deleted) {
        this.exam_id = exam_id;
        this.course = course;
        this.date = date;
        this.location = location;
        this.price = price;
        this.term = term;
        this.examRegistrations = examRegistrations;
        this.deleted = deleted;
    }

    public Long getExam_id() {
        return exam_id;
    }

    public void setExam_id(Long exam_id) {
        this.exam_id = exam_id;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TermDTO getTerm() {
        return term;
    }

    public void setTerm(TermDTO term) {
        this.term = term;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
