package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Course;
import com.eobrazovanje.university.entity.Teacher;
import com.eobrazovanje.university.entity.Teacher_engagement;
import com.eobrazovanje.university.mapper.dto.CourseDTO;
import com.eobrazovanje.university.mapper.dto.TeacherEngagementDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TeacherEngagementMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TeacherEngagementDTO convertToDto(Teacher_engagement teacher_engagement) {
        return modelMapper.map(teacher_engagement, TeacherEngagementDTO.class);
    }

    public Set<TeacherEngagementDTO> convertToDtos(Page<Teacher_engagement> teacherEngagementPage) {
        return teacherEngagementPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Teacher_engagement convertToEntity(TeacherEngagementDTO teacherEngagementDTO) {
        return modelMapper.map(teacherEngagementDTO, Teacher_engagement.class);
    }

    public Set<Teacher_engagement> convertToEntities(Collection<TeacherEngagementDTO> teacherEngagementDTOS) {
        return teacherEngagementDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
