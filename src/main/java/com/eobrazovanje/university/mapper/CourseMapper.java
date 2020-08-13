package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Course;
import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.mapper.dto.CourseDTO;
import com.eobrazovanje.university.mapper.dto.CourseEnrollmentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CourseDTO convertToDto(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    public Set<CourseDTO> convertToDtos(Page<Course> coursePage) {
        return coursePage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Course convertToEntity(CourseDTO courseDTO) {
        return modelMapper.map(courseDTO, Course.class);
    }

    public Set<Course> convertToEntities(Collection<CourseDTO> courseDTOS) {
        return courseDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }


}
