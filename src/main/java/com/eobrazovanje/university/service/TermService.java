package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.Term;
import com.eobrazovanje.university.mapper.TermMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TermDTO;
import com.eobrazovanje.university.repository.ExamRegistrationRepository;
import com.eobrazovanje.university.repository.TermRepository;
import com.eobrazovanje.university.service.interfaces.TermInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TermService implements TermInterface {

    @Autowired
    private TermRepository termRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamRegistrationService examRegistrationService;

    @Autowired
    private ExamRegistrationRepository examRegistrationRepository;

    @Autowired
    private TermMapper termMapper;

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

    public PagedResponse<TermDTO> getAllTerms(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Term> terms = termRepository.findAllByDeleted(pageable);

        if (terms.getNumberOfElements() == 0) {
            return new PagedResponse<TermDTO>(Collections.emptySet(), terms.getNumber(), terms.getSize(),
                    terms.getTotalElements(), terms.getTotalPages(), terms.isLast());
        }

        return new PagedResponse<TermDTO>(termMapper.convertToDtos(terms),  terms.getNumber(), terms.getSize(),
                terms.getTotalElements(), terms.getTotalPages(), terms.isLast());

    }

    public Set<Term> getAllTermsForStudent(Long id) {

        List<Term> terms = termRepository.findAllByDeletedOrdered();
        Set<Term> set_terms = new HashSet<Term>(terms);
        Set<Exam> exams = studentService.getStudentExams(id);

        for(Term t: set_terms) {
            Set<Exam> new_exams = new HashSet<>();
            for(Exam e: exams) {
                if(t.getTerm_id().equals(e.getTerm().getTerm_id())) {
                    new_exams.add(e);
                }
            }
           t.setExams(new_exams);

        }

        return set_terms;
    }

    public Set<Term> getAllTermsForStudentNotRegisteredExams(Long id) {
        Set<Term> terms = getAllTermsForStudent(id);
        Set<ExamRegistration> registrations = examRegistrationRepository.findAllByStudentSet(id);
        for(Term t: terms) {
            Set<Exam> exams = t.getExams();
            Iterator<Exam> iter = exams.iterator();
            while (iter.hasNext()) {
                Exam exam = iter.next();
                    for (ExamRegistration e : registrations) {
                        if (exam.getExam_id() == e.getExam().getExam_id() && String.valueOf(e.getStatus()).equals("ACTIVE")) {
                            iter.remove();
                        }
                    }
                t.setExams(exams);
            }
        }
        return terms;
    }


 }
