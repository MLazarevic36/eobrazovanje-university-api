package com.eobrazovanje.university.mapper.dto;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StudentDTO implements Serializable {

    private Long id;
    private String first_name;
    private String last_name;
    private String index_number;
    private Double account_balance;
    private UserDTO user;
    @JsonIgnore
    private Set<CourseEnrollmentDTO> enrollments = new HashSet<CourseEnrollmentDTO>();
    @JsonIgnore
    private Set<DocumentDTO> documents = new HashSet<DocumentDTO>();
    @JsonIgnore
    private Set<TransactionDTO> transactions = new HashSet<TransactionDTO>();
    @JsonIgnore
    private Set<ExamRegistrationDTO> examRegistrations = new HashSet<ExamRegistrationDTO>();
    private Boolean deleted;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String first_name, String last_name, String index_number, Double account_balance,
                      UserDTO user, Set<CourseEnrollmentDTO> enrollments, Set<DocumentDTO> documents,
                      Set<TransactionDTO> transactions, Set<ExamRegistrationDTO> examRegistrations, Boolean deleted) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.index_number = index_number;
        this.account_balance = account_balance;
        this.user = user;
        this.enrollments = enrollments;
        this.documents = documents;
        this.transactions = transactions;
        this.examRegistrations = examRegistrations;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExamRegistrations(Set<ExamRegistrationDTO> examRegistrations) {
        this.examRegistrations = examRegistrations;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Set<CourseEnrollmentDTO> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<CourseEnrollmentDTO> enrollments) {
        this.enrollments = enrollments;
    }

    public Set<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<DocumentDTO> documents) {
        this.documents = documents;
    }

    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public Set<ExamRegistrationDTO> getExamRegistrations() {
        return examRegistrations;
    }

    public void setExams(Set<ExamRegistrationDTO> examRegistrations) {
        this.examRegistrations = examRegistrations;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
