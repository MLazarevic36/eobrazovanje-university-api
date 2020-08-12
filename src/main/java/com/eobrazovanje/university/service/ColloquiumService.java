package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Colloquium;
import com.eobrazovanje.university.repository.ColloquiumRepository;
import com.eobrazovanje.university.service.interfaces.ColloquiumInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ColloquiumService implements ColloquiumInterface {

    @Autowired
    private ColloquiumRepository colloquiumRepository;

    @Override
    public Colloquium findOne(Long id) {
        return colloquiumRepository.getOne(id);
    }

    @Override
    public Page<Colloquium> findAll(Pageable pageable) {
        return colloquiumRepository.findAll(pageable);
    }

    @Override
    public Colloquium save(Colloquium colloquium) {
        return colloquiumRepository.save(colloquium);
    }

    @Override
    public Colloquium update(Colloquium colloquium) {
        return colloquiumRepository.save(colloquium);
    }

    @Override
    public void delete(Colloquium colloquium) {
        colloquium.setDeleted(true);
        colloquiumRepository.save(colloquium);
    }
}
