package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;

public class DocumentDTO implements Serializable {

    private Long id;
    private String name;
    private String uri;
    private StudentDTO studentDTO;
    private Boolean deleted;

    public DocumentDTO() {
    }

    public DocumentDTO(Long id, String name, String uri, StudentDTO studentDTO, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.uri = uri;
        this.studentDTO = studentDTO;
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
