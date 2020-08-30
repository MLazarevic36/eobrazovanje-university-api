package com.eobrazovanje.university.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exams")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id", unique = true, nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "colloquium_points")
    private int colloquium_points;

    @Column(name = "exam_points")
    private int exam_points;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "term", referencedColumnName = "term_id", nullable = false)
    private Term term;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<ExamRegistration> examRegistrations = new HashSet<>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean deleted;

    public Exam() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Set<ExamRegistration> getExamRegistrations() {
        return examRegistrations;
    }

    public void setExamRegistrations(Set<ExamRegistration> examRegistrations) {
        this.examRegistrations = examRegistrations;
    }
}
