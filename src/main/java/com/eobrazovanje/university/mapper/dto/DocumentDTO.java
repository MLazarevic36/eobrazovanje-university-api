package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;

public class DocumentDTO implements Serializable {

    private Long id;
    private String name;
    private byte[] file;
    private StudentDTO student;
    private Boolean deleted;

    public DocumentDTO() {
    }

    public DocumentDTO(Long id, String name, byte[] file, StudentDTO student, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.student = student;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
