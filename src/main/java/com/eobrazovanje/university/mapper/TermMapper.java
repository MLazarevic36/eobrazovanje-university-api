package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.Term;
import com.eobrazovanje.university.mapper.dto.ExamDTO;
import com.eobrazovanje.university.mapper.dto.TermDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TermMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TermDTO convertToDto(Term term) {
        return modelMapper.map(term, TermDTO.class);
    }

    public Set<TermDTO> convertToDtos(Page<Term> termPage) {
        return termPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Set<TermDTO> convertToDtosList(List<Term> terms) {
        return terms.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Term convertToEntity(TermDTO termDTO) {
        return modelMapper.map(termDTO, Term.class);
    }

    public Set<Term> convertToEntities(Collection<TermDTO> termDTOS) {
        return termDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }


}
