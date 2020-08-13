package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StudentDTO implements Serializable {

    private Long id;
    private String first_name;
    private String last_name;
    private String index_number;
    private Double account_balance;
    private UserDTO userDTO;
    private Set<CourseEnrollmentDTO> enrollmentDTOS = new HashSet<>();
    private Set<DocumentDTO> documentDTOS = new HashSet<>();
    private Set<TransactionDTO> transactionDTOS = new HashSet<>();
    private Set<ExamDTO> examDTOS = new HashSet<>();
    private Boolean deleted;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String first_name, String last_name, String index_number, Double account_balance,
                      UserDTO userDTO, Set<CourseEnrollmentDTO> enrollmentDTOS, Set<DocumentDTO> documentDTOS,
                      Set<TransactionDTO> transactionDTOS, Set<ExamDTO> examDTOS, Boolean deleted) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.index_number = index_number;
        this.account_balance = account_balance;
        this.userDTO = userDTO;
        this.enrollmentDTOS = enrollmentDTOS;
        this.documentDTOS = documentDTOS;
        this.transactionDTOS = transactionDTOS;
        this.examDTOS = examDTOS;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Set<CourseEnrollmentDTO> getEnrollmentDTOS() {
        return enrollmentDTOS;
    }

    public void setEnrollmentDTOS(Set<CourseEnrollmentDTO> enrollmentDTOS) {
        this.enrollmentDTOS = enrollmentDTOS;
    }

    public Set<DocumentDTO> getDocumentDTOS() {
        return documentDTOS;
    }

    public void setDocumentDTOS(Set<DocumentDTO> documentDTOS) {
        this.documentDTOS = documentDTOS;
    }

    public Set<TransactionDTO> getTransactionDTOS() {
        return transactionDTOS;
    }

    public void setTransactionDTOS(Set<TransactionDTO> transactionDTOS) {
        this.transactionDTOS = transactionDTOS;
    }

    public Set<ExamDTO> getExamDTOS() {
        return examDTOS;
    }

    public void setExamDTOS(Set<ExamDTO> examDTOS) {
        this.examDTOS = examDTOS;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
