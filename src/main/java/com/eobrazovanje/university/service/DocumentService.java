package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Document;
import com.eobrazovanje.university.repository.DocumentRepository;
import com.eobrazovanje.university.service.interfaces.DocumentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentService implements DocumentInterface {

    @Autowired
    private DocumentRepository documentRepository;

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
}
