package com.eobrazovanje.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
    private Long student_id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "index_number", nullable = false)
    private String index_number;

    @Column(name = "account_balance")
    private Double account_balance;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Set<Course_enrollment> course_enrollments = new HashSet<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Set<Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ExamRegistration> exam_registrations = new HashSet<>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean deleted;

    public Student() {
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getIndex_number() {
        return index_number;
    }

    public void setIndex_number(String index_number) {
        this.index_number = index_number;
    }

    public Double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Double account_balance) {
        this.account_balance = account_balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Course_enrollment> getCourse_enrollments() {
        return course_enrollments;
    }

    public void setCourse_enrollments(Set<Course_enrollment> course_enrollments) {
        this.course_enrollments = course_enrollments;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<ExamRegistration> getExam_registrations() {
        return exam_registrations;
    }

    public void setExam_registrations(Set<ExamRegistration> exam_registrations) {
        this.exam_registrations = exam_registrations;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
