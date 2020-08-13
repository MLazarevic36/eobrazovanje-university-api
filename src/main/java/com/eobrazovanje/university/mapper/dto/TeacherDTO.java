package com.eobrazovanje.university.mapper.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TeacherDTO implements Serializable {

    private Long id;
    private String first_name;
    private String last_name;
    private UserDTO userDTO;
    private Set<TeacherEngagementDTO> engagementDTOS = new HashSet<>();
    private Boolean deleted;

    public TeacherDTO() {
    }

    public TeacherDTO(Long id, String first_name, String last_name, UserDTO userDTO, Set<TeacherEngagementDTO> engagementDTOS, Boolean deleted) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.userDTO = userDTO;
        this.engagementDTOS = engagementDTOS;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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
