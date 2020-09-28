package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Document;
import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.mapper.DocumentMapper;
import com.eobrazovanje.university.mapper.dto.DocumentDTO;
import com.eobrazovanje.university.mapper.dto.ExamRegistrationDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.repository.DocumentRepository;
import com.eobrazovanje.university.service.interfaces.DocumentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DocumentService implements DocumentInterface {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public Document findOne(Long id) {
        return documentRepository.getOne(id);
    }

    @Override
    public Page<Document> findAll(Pageable pageable) {
        return documentRepository.findAll(pageable);
    }

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document update(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public void delete(Document document) {
        document.setDeleted(true);
        documentRepository.save(document);
    }

    public PagedResponse<DocumentDTO> getAllDocumentsByStudent(Long student_id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "document_id");
        Page<Document> documents = documentRepository.findDocumentsByStudent(student_id, pageable);

        if (documents.getNumberOfElements() == 0) {
            return new PagedResponse<DocumentDTO>(Collections.emptySet(), documents.getNumber(), documents.getSize(),
                    documents.getTotalElements(), documents.getTotalPages(), documents.isLast());
        }

        return new PagedResponse<DocumentDTO>(documentMapper.convertToDtos(documents),
                documents.getNumber(), documents.getSize(),
                documents.getTotalElements(), documents.getTotalPages(), documents.isLast());

    }
}
