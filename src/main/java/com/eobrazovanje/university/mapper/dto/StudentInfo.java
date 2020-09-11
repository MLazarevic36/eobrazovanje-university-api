package com.eobrazovanje.university.mapper.dto;

public class StudentInfo {

    private Long student_id;
    private String first_name;
    private String last_name;
    private String index_number;
    private Double account_balance;
    private Boolean deleted;

    public StudentInfo(Long student_id, String first_name, String last_name, String index_number, Double account_balance, Boolean deleted) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.index_number = index_number;
        this.account_balance = account_balance;
        this.deleted = deleted;
    }

    public StudentInfo() {
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
