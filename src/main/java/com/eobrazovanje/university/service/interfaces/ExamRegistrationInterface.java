package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.ExamRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExamRegistrationInterface {

    ExamRegistration findOne(Long id);
    Page<ExamRegistration> findAll(Pageable pageable);
    ExamRegistration save(ExamRegistration examRegistration);
    ExamRegistration update(ExamRegistration examRegistration);
    void delete(ExamRegistration examRegistration);

}
