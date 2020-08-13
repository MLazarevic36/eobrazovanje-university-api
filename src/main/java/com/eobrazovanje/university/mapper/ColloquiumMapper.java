package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Colloquium;
import com.eobrazovanje.university.mapper.dto.ColloquiumDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ColloquiumMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ColloquiumDTO convertToDto(Colloquium colloquium) {
        return modelMapper.map(colloquium, ColloquiumDTO.class);
    }

    public Set<ColloquiumDTO> convertToDtos(Page<Colloquium> colloquiumPage) {
        return colloquiumPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Colloquium convertToEntity(ColloquiumDTO colloquiumDTO) {
        return modelMapper.map(colloquiumDTO, Colloquium.class);
    }

    public Set<Colloquium> convertToEntities(Collection<ColloquiumDTO> colloquiumDTOS) {
        return colloquiumDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
