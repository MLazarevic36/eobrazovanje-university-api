package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CourseDTO implements Serializable {

    private Long id;
    private String name;
    private Set<TeacherEngagementDTO> engagementDTOS = new HashSet<>();
    private Boolean deleted;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name, Set<TeacherEngagementDTO> engagementDTOS, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.engagementDTOS = engagementDTOS;
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

    public Set<TeacherEngagementDTO> getEngagementDTOS() {
        return engagementDTOS;
    }

    public void setEngagementDTOS(Set<TeacherEngagementDTO> engagementDTOS) {
        this.engagementDTOS = engagementDTOS;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
