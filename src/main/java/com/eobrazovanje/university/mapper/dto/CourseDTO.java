package com.eobrazovanje.university.mapper.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CourseDTO implements Serializable {

    private Long id;
    private String name;
    @JsonIgnore
    private Set<TeacherEngagementDTO> engagements = new HashSet<TeacherEngagementDTO>();
    private Boolean deleted;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name, Set<TeacherEngagementDTO> engagements, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.engagements = engagements;
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

    public Set<TeacherEngagementDTO> getEngagements() {
        return engagements;
    }

    public void setEngagements(Set<TeacherEngagementDTO> engagements) {
        this.engagements = engagements;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
