package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentInterface {

    Document findOne(Long id);
    Page<Document> findAll(Pageable pageable);
    Document save(Document document);
    Document update(Document document);
    void delete(Document document);

}
