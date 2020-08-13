package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Course;
import com.eobrazovanje.university.entity.Document;
import com.eobrazovanje.university.mapper.dto.CourseDTO;
import com.eobrazovanje.university.mapper.dto.DocumentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DocumentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DocumentDTO convertToDto(Document document) {
        return modelMapper.map(document, DocumentDTO.class);
    }

    public Set<DocumentDTO> convertToDtos(Page<Document> documentPage) {
        return documentPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Document convertToEntity(DocumentDTO documentDTO) {
        return modelMapper.map(documentDTO, Document.class);
    }

    public Set<Document> convertToEntities(Collection<DocumentDTO> documentDTOS) {
        return documentDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
