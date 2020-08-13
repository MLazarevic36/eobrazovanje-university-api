package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Colloquium;
import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.mapper.dto.ColloquiumDTO;
import com.eobrazovanje.university.mapper.dto.CourseEnrollmentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CourseEnrollmentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CourseEnrollmentDTO convertToDto(Course_enrollment course_enrollment) {
        return modelMapper.map(course_enrollment, CourseEnrollmentDTO.class);
    }

    public Set<CourseEnrollmentDTO> convertToDtos(Page<Course_enrollment> courseEnrollmentPage) {
        return courseEnrollmentPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Course_enrollment convertToEntity(CourseEnrollmentDTO courseEnrollmentDTO) {
        return modelMapper.map(courseEnrollmentDTO, Course_enrollment.class);
    }

    public Set<Course_enrollment> convertToEntities(Collection<CourseEnrollmentDTO> courseEnrollmentDTOS) {
        return courseEnrollmentDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
