package com.eobrazovanje.university.mapper.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

public class DocumentDTO implements Serializable {

    private Long document_id;
    private String name;
    private byte[] file;
    private StudentDTO student;
    private Boolean deleted;

    public DocumentDTO() {
    }

    public DocumentDTO(Long document_id, String name, byte[] file, StudentDTO student, Boolean deleted) {
        this.document_id = document_id;
        this.name = name;
        this.file = file;
        this.student = student;
        this.deleted = deleted;
    }

    public Long getDocument_id() {
        return document_id;
    }

    public void setDocument_id(Long document_id) {
        this.document_id = document_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
