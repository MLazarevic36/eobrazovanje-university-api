package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.repository.ExamRepository;
import com.eobrazovanje.university.service.interfaces.ExamInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExamService implements ExamInterface {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam findOne(Long id) {
        return examRepository.getOne(id);
    }

    @Override
    public Page<Exam> findAll(Pageable pageable) {
        return examRepository.findAll(pageable);
    }

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam update(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public void delete(Exam exam) {
        exam.setDeleted(true);
        examRepository.save(exam);
    }
}
