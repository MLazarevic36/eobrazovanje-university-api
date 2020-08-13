package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;

public class ColloquiumDTO implements Serializable {

    private Long id;
    private String name;
    private int points;
    private ExamDTO examDTO;
    private Boolean deleted;

    public ColloquiumDTO() {
    }

    public ColloquiumDTO(Long id, String name, int points, ExamDTO examDTO, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.examDTO = examDTO;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ExamDTO getExamDTO() {
        return examDTO;
    }

    public void setExamDTO(ExamDTO examDTO) {
        this.examDTO = examDTO;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
