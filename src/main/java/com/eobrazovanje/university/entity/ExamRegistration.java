package com.eobrazovanje.university.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exam_registrations")
public class ExamRegistration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_registration_id", unique = true, nullable = false)
    private Long exam_registration_id;

    @Column(name = "colloquium_points")
    private int colloquium_points;

    @Column(name = "exam_points")
    private int exam_points;

    @Column(name = "grade")
    private int grade;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "exam", referencedColumnName = "exam_id", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "student_id", nullable = false)
    private Student student;

    @Column(name="registered", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean registered;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean deleted;

    public ExamRegistration() {
    }

    public Long getExam_registration_id() {
        return exam_registration_id;
    }

    public void setExam_registration_id(Long exam_registration_id) {
        this.exam_registration_id = exam_registration_id;
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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
}
