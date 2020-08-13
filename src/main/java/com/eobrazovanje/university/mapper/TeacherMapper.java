package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Teacher;
import com.eobrazovanje.university.entity.Teacher_engagement;
import com.eobrazovanje.university.mapper.dto.TeacherDTO;
import com.eobrazovanje.university.mapper.dto.TeacherEngagementDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TeacherDTO convertToDto(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    public Set<TeacherDTO> convertToDtos(Page<Teacher> teacherPage) {
        return teacherPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Teacher convertToEntity(TeacherDTO teacherDTO) {
        return modelMapper.map(teacherDTO, Teacher.class);
    }

    public Set<Teacher> convertToEntities(Collection<TeacherDTO> teacherDTOS) {
        return teacherDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
