package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExamInterface {

    Exam findOne(Long id);
    Page<Exam> findAll(Pageable pageable);
    Exam save(Exam exam);
    Exam update(Exam exam);
    void delete(Exam exam);
}
