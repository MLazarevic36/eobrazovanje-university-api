package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.repository.ExamRegistrationRepository;
import com.eobrazovanje.university.service.interfaces.ExamRegistrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExamRegistrationService implements ExamRegistrationInterface {

    @Autowired
    private ExamRegistrationRepository examRegistrationRepository;

    @Override
    public ExamRegistration findOne(Long id) {
        return examRegistrationRepository.getOne(id);
    }

    @Override
    public Page<ExamRegistration> findAll(Pageable pageable) {
        return examRegistrationRepository.findAll(pageable);
    }

    @Override
    public ExamRegistration save(ExamRegistration examRegistration) {
        return examRegistrationRepository.save(examRegistration);
    }

    @Override
    public ExamRegistration update(ExamRegistration examRegistration) {
        return examRegistrationRepository.save(examRegistration);
    }

    @Override
    public void delete(ExamRegistration examRegistration) {
        examRegistration.setDeleted(true);
        examRegistrationRepository.save(examRegistration);
    }
}
