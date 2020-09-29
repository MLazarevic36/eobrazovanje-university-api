package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.Status;
import com.eobrazovanje.university.entity.Term;
import com.eobrazovanje.university.mapper.TermMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TermDTO;
import com.eobrazovanje.university.repository.ExamRegistrationRepository;
import com.eobrazovanje.university.repository.ExamRepository;
import com.eobrazovanje.university.repository.TermRepository;
import com.eobrazovanje.university.service.interfaces.TermInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class    TermService implements TermInterface {

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

    @Autowired
    private ExamRepository examRepository;

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

    public List<Term> getAllTermsForStudent(Long id) {

        List<Term> terms = termRepository.findAllByDeletedOrdered();
//        Set<Term> set_terms = new HashSet<Term>(terms);
        Set<Exam> exams = studentService.getStudentExams(id);

        for(Term t: terms) {
            Set<Exam> new_exams = new HashSet<>();
            for(Exam e: exams) {
                if(t.getId().equals(e.getTerm().getId())) {
                    new_exams.add(e);
                }
            }
           t.setExams(new_exams);

        }

        return terms;
    }

    public List<Term> getAllTermsForStudentNotRegisteredExams(Long id) {
        List<Term> terms = getAllTermsForStudent(id);

        Set<ExamRegistration> registrations = examRegistrationRepository.findAllByStudentSet(id);
        List<Long> coursesToRemove = new ArrayList<>();
        List<Long> examsToRemove = new ArrayList<>();

        for (ExamRegistration er: registrations){
            if(er.getStatus().name().equals("PASSED")){
                Long courseId = er.getExam().getCourse().getId();
                Set<Exam> exams = examRepository.findByDeletedFalseAndCourse_Id(courseId);
                coursesToRemove.addAll(exams.stream().map(ex -> ex.getCourse().getId()).collect(Collectors.toSet()));
            } else if(er.getStatus().name().equals("ACTIVE")){
                examsToRemove.add(er.getExam().getId());
            }
        }

        for (Term term: terms) {
            Set<Exam> filteredExams = new HashSet<>();
            for (Exam exam : term.getExams()) {
                if((!coursesToRemove.contains(exam.getCourse().getId()))
                        && (!examsToRemove.contains(exam.getId()))){
                    filteredExams.add(exam);
                }
            }
            term.setExams(filteredExams);
        }

        terms.sort(Comparator.comparing(Term::getId));
        return terms;
    }


 }
