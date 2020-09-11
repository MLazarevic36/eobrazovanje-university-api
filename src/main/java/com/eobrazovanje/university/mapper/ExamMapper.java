package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Course;
import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.mapper.dto.CourseDTO;
import com.eobrazovanje.university.mapper.dto.ExamDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ExamMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ExamDTO convertToDto(Exam exam) {
        return modelMapper.map(exam, ExamDTO.class);
    }

    public Set<ExamDTO> convertToDtos(Page<Exam> examPage) {
        return examPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Set<ExamDTO> convertToDtosSet(Set<Exam> exams) {
        return exams.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Exam convertToEntity(ExamDTO examDTO) {
        return modelMapper.map(examDTO, Exam.class);
    }

    public Set<Exam> convertToEntities(Collection<ExamDTO> examDTOS) {
        return examDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
