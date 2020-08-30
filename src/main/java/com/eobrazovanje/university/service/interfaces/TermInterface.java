package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.Term;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TermInterface {

    Term findOne(Long id);
    Page<Term> findAll(Pageable pageable);
    Term save(Term term);
    Term update(Term term);
    void delete(Term term);

}
