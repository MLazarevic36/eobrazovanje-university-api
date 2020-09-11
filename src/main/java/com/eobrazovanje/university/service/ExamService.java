package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.mapper.ExamMapper;
import com.eobrazovanje.university.mapper.dto.ExamDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.UserDTO;
import com.eobrazovanje.university.repository.ExamRepository;
import com.eobrazovanje.university.service.interfaces.ExamInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ExamService implements ExamInterface {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamMapper examMapper;

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

    public PagedResponse<ExamDTO> getAllExams(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "exam_id");
        Page<Exam> exams = examRepository.findAllByDeleted(pageable);

        if (exams.getNumberOfElements() == 0) {
            return new PagedResponse<ExamDTO>(Collections.emptySet(), exams.getNumber(), exams.getSize(),
                    exams.getTotalElements(), exams.getTotalPages(), exams.isLast());
        }

        return new PagedResponse<ExamDTO>(examMapper.convertToDtos(exams),  exams.getNumber(), exams.getSize(),
                exams.getTotalElements(), exams.getTotalPages(), exams.isLast());

    }
}
