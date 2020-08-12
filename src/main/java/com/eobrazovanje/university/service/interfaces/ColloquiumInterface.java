package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Colloquium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ColloquiumInterface {

    Colloquium findOne(Long id);
    Page<Colloquium> findAll(Pageable pageable);
    Colloquium save(Colloquium colloquium);
    Colloquium update(Colloquium colloquium);
    void delete(Colloquium colloquium);
}
