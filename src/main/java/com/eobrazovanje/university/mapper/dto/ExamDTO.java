package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.Status;
import com.eobrazovanje.university.entity.Term;
import com.fasterxml.jackson.annotation.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class ExamDTO implements Serializable {

    private Long id;
    private CourseDTO course;
    private Timestamp date;
    private int colloquium_points;
    private int exam_points;
    private String location;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private TermDTO term;
    @JsonManagedReference
    private Set<ExamRegistrationDTO> examRegistrations = new HashSet<ExamRegistrationDTO>();
    private Boolean deleted;

    public ExamDTO() {
    }

    public ExamDTO(Long id, CourseDTO course, Timestamp date, int colloquium_points, int exam_points, String location,
                   TermDTO term, Set<ExamRegistrationDTO> examRegistrations, Boolean deleted) {
        this.id = id;
        this.course = course;
        this.date = date;
        this.colloquium_points = colloquium_points;
        this.exam_points = exam_points;
        this.location = location;
        this.term = term;
        this.examRegistrations = examRegistrations;
        this.deleted = deleted;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
}
