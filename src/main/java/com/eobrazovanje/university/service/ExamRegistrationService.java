package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.Status;
import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.entity.Transaction;
import com.eobrazovanje.university.mapper.ExamRegistrationMapper;
import com.eobrazovanje.university.mapper.dto.ExamRegistrationDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.repository.ExamRegistrationRepository;
import com.eobrazovanje.university.repository.StudentRepository;
import com.eobrazovanje.university.service.interfaces.ExamRegistrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class ExamRegistrationService implements ExamRegistrationInterface {

    @Autowired
    private ExamRegistrationRepository examRegistrationRepository;

    @Autowired
    private ExamRegistrationMapper examRegistrationMapper;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

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
        addTransaction(examRegistration);
        return examRegistrationRepository.save(examRegistration);
    }


    @Override
    public ExamRegistration update(ExamRegistration examRegistration) {

        int totalPoints = examRegistration.getColloquium_points() + examRegistration.getExam_points();
        if(totalPoints >= 90) {
            examRegistration.setGrade(10);
            examRegistration.setStatus(Status.PASSED);
        }else if (totalPoints >= 80) {
            examRegistration.setGrade(9);
            examRegistration.setStatus(Status.PASSED);
        }else if (totalPoints >= 70) {
            examRegistration.setGrade(8);
            examRegistration.setStatus(Status.PASSED);
        }else if (totalPoints >= 60) {
            examRegistration.setGrade(7);
            examRegistration.setStatus(Status.PASSED);
        }else if (totalPoints >= 50) {
            examRegistration.setGrade(6);
            examRegistration.setStatus(Status.PASSED);
        }else if (totalPoints >= 0) {
            examRegistration.setGrade(5);
            examRegistration.setStatus(Status.ACTIVE);

        }



        return examRegistrationRepository.save(examRegistration);
    }



    @Override
    public void delete(ExamRegistration examRegistration) {
        unregister(examRegistration);
        examRegistration.setDeleted(true);
        examRegistrationRepository.save(examRegistration);
    }

    public PagedResponse<ExamRegistrationDTO> getAllExamRegistrations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "exam_registration_id");
        Page<ExamRegistration> exam_registrations = examRegistrationRepository.findAllByDeleted(pageable);

        if (exam_registrations.getNumberOfElements() == 0) {
            return new PagedResponse<ExamRegistrationDTO>(Collections.emptySet(), exam_registrations.getNumber(), exam_registrations.getSize(),
                    exam_registrations.getTotalElements(), exam_registrations.getTotalPages(), exam_registrations.isLast());
        }

        return new PagedResponse<ExamRegistrationDTO>(examRegistrationMapper.convertToDtos(exam_registrations),
                exam_registrations.getNumber(), exam_registrations.getSize(),
                exam_registrations.getTotalElements(), exam_registrations.getTotalPages(), exam_registrations.isLast());

    }

    public PagedResponse<ExamRegistrationDTO> getAllExamRegistrationsByStudent(Long student_id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "exam_registration_id");
        Page<ExamRegistration> exam_registrations = examRegistrationRepository.findAllByStudentAndRegistered(student_id, pageable);

        if (exam_registrations.getNumberOfElements() == 0) {
            return new PagedResponse<ExamRegistrationDTO>(Collections.emptySet(), exam_registrations.getNumber(), exam_registrations.getSize(),
                    exam_registrations.getTotalElements(), exam_registrations.getTotalPages(), exam_registrations.isLast());
        }

        return new PagedResponse<ExamRegistrationDTO>(examRegistrationMapper.convertToDtos(exam_registrations),
                exam_registrations.getNumber(), exam_registrations.getSize(),
                exam_registrations.getTotalElements(), exam_registrations.getTotalPages(), exam_registrations.isLast());

    }

    public PagedResponse<ExamRegistrationDTO> getAllExamRegistrationsByStudentPassed(Long student_id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "exam_registration_id");
        Page<ExamRegistration> exam_registrations = examRegistrationRepository.findAllByStudentAndPassed(student_id, pageable);

        if (exam_registrations.getNumberOfElements() == 0) {
            return new PagedResponse<ExamRegistrationDTO>(Collections.emptySet(), exam_registrations.getNumber(), exam_registrations.getSize(),
                    exam_registrations.getTotalElements(), exam_registrations.getTotalPages(), exam_registrations.isLast());
        }

        return new PagedResponse<ExamRegistrationDTO>(examRegistrationMapper.convertToDtos(exam_registrations),
                exam_registrations.getNumber(), exam_registrations.getSize(),
                exam_registrations.getTotalElements(), exam_registrations.getTotalPages(), exam_registrations.isLast());

    }

    public void addTransaction(ExamRegistration examRegistration) {
        Transaction transaction = new Transaction();
        transaction.setStudent(examRegistration.getStudent());
        transaction.setAmount(examRegistration.getExam().getPrice());
        transaction.setDate(new Date());
        transaction.setDeleted(false);
        transaction.setPurpose("Exam registration");
        transactionService.save(transaction);
        Student student = studentRepository.getOne(examRegistration.getStudent().getId());
        student.setAccount_balance(student.getAccount_balance() - examRegistration.getExam().getPrice());
        studentService.update(student);
    }

    public void unregister(ExamRegistration examRegistration) {
        Transaction transaction = new Transaction();
        transaction.setStudent(examRegistration.getStudent());
        transaction.setAmount(examRegistration.getExam().getPrice());
        transaction.setDate(new Date());
        transaction.setDeleted(false);
        transaction.setPurpose("Exam unregistration");
        transactionService.save(transaction);
        Student student = studentRepository.getOne(examRegistration.getStudent().getId());
        student.setAccount_balance(student.getAccount_balance() + examRegistration.getExam().getPrice());
        studentService.update(student);
    }

}
