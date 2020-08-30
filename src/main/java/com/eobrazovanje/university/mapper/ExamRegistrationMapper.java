package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.mapper.dto.ExamDTO;
import com.eobrazovanje.university.mapper.dto.ExamRegistrationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ExamRegistrationMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ExamRegistrationDTO convertToDto(ExamRegistration examRegistration) {
        return modelMapper.map(examRegistration, ExamRegistrationDTO.class);
    }

    public Set<ExamRegistrationDTO> convertToDtos(Page<ExamRegistration> examRegistrationPage) {
        return examRegistrationPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public ExamRegistration convertToEntity(ExamRegistrationDTO examRegistrationDTO) {
        return modelMapper.map(examRegistrationDTO, ExamRegistration.class);
    }

    public Set<ExamRegistration> convertToEntities(Collection<ExamRegistrationDTO> examRegistrationDTOS) {
        return examRegistrationDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }
}
