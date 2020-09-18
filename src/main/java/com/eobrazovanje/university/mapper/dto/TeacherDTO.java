package com.eobrazovanje.university.mapper.dto;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TeacherDTO implements Serializable {

    private Long teacher_id;
    private String first_name;
    private String last_name;
    private UserDTO user;
    @JsonIgnore
    private Set<TeacherEngagementDTO> engagements = new HashSet<TeacherEngagementDTO>();
    private Boolean deleted;

    public TeacherDTO() {
    }

    public TeacherDTO(Long teacher_id, String first_name, String last_name, UserDTO user, Set<TeacherEngagementDTO> engagements,
                      Boolean deleted) {
        this.teacher_id = teacher_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user = user;
        this.engagements = engagements;
        this.deleted = deleted;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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
