package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;
import java.util.Date;

public class TransactionDTO implements Serializable {

    private Long id;
    private StudentDTO studentDTO;
    private String purpose;
    private Double amount;
    private Date date;
    private Boolean deleted;

    public TransactionDTO() {
    }

    public TransactionDTO(Long id, StudentDTO studentDTO, String purpose, Double amount, Date date, Boolean deleted) {
        this.id = id;
        this.studentDTO = studentDTO;
        this.purpose = purpose;
        this.amount = amount;
        this.date = date;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
