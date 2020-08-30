package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.Term;
import com.eobrazovanje.university.repository.TermRepository;
import com.eobrazovanje.university.service.interfaces.TermInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TermService implements TermInterface {

    @Autowired
    private TermRepository termRepository;

    @Override
    public Term findOne(Long id) {
        return termRepository.getOne(id);
    }

    @Override
    public Page<Term> findAll(Pageable pageable) {
        return termRepository.findAll(pageable);
    }

    @Override
    public Term save(Term term) {
        return termRepository.save(term);
    }

    @Override
    public Term update(Term term) {
        return termRepository.save(term);
    }

    @Override
    public void delete(Term term) {
        term.setDeleted(true);
        termRepository.save(term);
    }
}
