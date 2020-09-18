package com.eobrazovanje.university.mapper.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TransactionDTO implements Serializable {

    private Long transaction_id;

    private StudentDTO student;
    private String purpose;
    private double amount;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date;
    private Boolean deleted;

    public TransactionDTO() {
    }

    public TransactionDTO(Long transaction_id, StudentDTO student, String purpose, double amount, Date date, Boolean deleted) {
        this.transaction_id = transaction_id;
        this.student = student;
        this.purpose = purpose;
        this.amount = amount;
        this.date = date;
        this.deleted = deleted;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
