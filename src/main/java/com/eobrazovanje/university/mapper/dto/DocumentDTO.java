package com.eobrazovanje.university.mapper.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

public class DocumentDTO implements Serializable {

    private Long document_id;
    private String name;
    private String uri;
    @JsonBackReference(value = "student-documents")
    private StudentDTO student;
    private Boolean deleted;

    public DocumentDTO() {
    }

    public DocumentDTO(Long document_id, String name, String uri, StudentDTO student, Boolean deleted) {
        this.document_id = document_id;
        this.name = name;
        this.uri = uri;
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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
