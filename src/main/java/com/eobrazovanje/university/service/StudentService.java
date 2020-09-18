package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.*;
import com.eobrazovanje.university.mapper.CourseEnrollmentMapper;
import com.eobrazovanje.university.mapper.ExamRegistrationMapper;
import com.eobrazovanje.university.mapper.StudentMapper;
import com.eobrazovanje.university.mapper.TransactionMapper;
import com.eobrazovanje.university.mapper.dto.*;
import com.eobrazovanje.university.repository.*;
import com.eobrazovanje.university.service.interfaces.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService implements StudentInterface {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamRegistrationRepository examRegistrationRepository;

    @Autowired
    private CourseEnrollmentRepository courseEnrollmentRepository;

    @Autowired
    private CourseEnrollmentMapper courseEnrollmentMapper;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private ExamRegistrationMapper examRegistrationMapper;

    @Override
    public Student findOne(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        student.setDeleted(true);
        studentRepository.save(student);
    }

    public PagedResponse<StudentDTO> getAllStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "student_id");
        Page<Student> students = studentRepository.findAllByDeleted(pageable);

        if (students.getNumberOfElements() == 0) {
            return new PagedResponse<StudentDTO>(Collections.emptySet(), students.getNumber(), students.getSize(),
                    students.getTotalElements(), students.getTotalPages(), students.isLast());
        }

        return new PagedResponse<StudentDTO>(studentMapper.convertToDtos(students), students.getNumber(), students.getSize(),
                students.getTotalElements(), students.getTotalPages(), students.isLast());

    }

    public PagedResponse<CourseEnrollmentDTO> getAllStudentEnrollments(Long id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "course_enrollment_id");

        Page<Course_enrollment> enrollments = courseEnrollmentRepository.findAllByDeletedByStudent(id, pageable);

        if (enrollments.getNumberOfElements() == 0) {
            return new PagedResponse<CourseEnrollmentDTO>(Collections.emptySet(), enrollments.getNumber(), enrollments.getSize(),
                    enrollments.getTotalElements(), enrollments.getTotalPages(), enrollments.isLast());
        }

        return new PagedResponse<CourseEnrollmentDTO>(courseEnrollmentMapper.convertToDtos(enrollments), enrollments.getNumber(), enrollments.getSize(),
                enrollments.getTotalElements(), enrollments.getTotalPages(), enrollments.isLast());

    }

    public PagedResponse<ExamRegistrationDTO> getAllStudentExamsForUnregister(Long id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "exam_registration_id");

        Page<ExamRegistration> registrations = examRegistrationRepository.findAllByStudentForUnregister(id, pageable);

        if (registrations.getNumberOfElements() == 0) {
            return new PagedResponse<ExamRegistrationDTO>(Collections.emptySet(), registrations.getNumber(), registrations.getSize(),
                    registrations.getTotalElements(), registrations.getTotalPages(), registrations.isLast());
        }

        return new PagedResponse<ExamRegistrationDTO>(examRegistrationMapper.convertToDtos(registrations), registrations.getNumber(), registrations.getSize(),
                registrations.getTotalElements(), registrations.getTotalPages(), registrations.isLast());

    }

    public Set<Course_enrollment> getStudentEnrollments(Long id) {
        Student student = studentRepository.getOne(id);

        return new HashSet<>(student.getCourse_enrollments());
    }

    public Set<Exam> getStudentExams(Long id) {
        Set<Exam> exams = new HashSet<>();
        Set<Exam> all_exams = examRepository.findAllByDeletedSet();
        Student student = studentRepository.getOne(id);

        for(Course_enrollment c : student.getCourse_enrollments()) {
            for(Exam e: all_exams) {
                if(c.getCourse().getCourse_id() == e.getCourse().getCourse_id()) {
                    exams.add(e);
                }
            }

        }
        return  exams;
    }

    public Set<ExamRegistration> getStudentExamRegistrations(Long id) {
        Set<ExamRegistration> registrations = new HashSet<>();
        Set<ExamRegistration> all_registrations = examRegistrationRepository.findAllByDeletedSet();
        Student student = studentRepository.getOne(id);
        for(ExamRegistration examRegistration : student.getExam_registrations()) {
            for(ExamRegistration e: all_registrations) {
                if(examRegistration.getStudent().getStudent_id() == e.getStudent().getStudent_id()) {
                    registrations.add(e);
                }
            }
        }
        return registrations;
    }

    public Student getStudentByUser(Long id) {
        return studentRepository.findStudentByUser(id);
    }

    public PagedResponse<TransactionDTO> getAllStudentTransactions(Long id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "transaction_id");

        Page<Transaction> transactions = transactionRepository.findTransactionsByStudent(id, pageable);

        if (transactions.getNumberOfElements() == 0) {
            return new PagedResponse<TransactionDTO>(Collections.emptySet(), transactions.getNumber(), transactions.getSize(),
                    transactions.getTotalElements(), transactions.getTotalPages(), transactions.isLast());
        }

        return new PagedResponse<TransactionDTO>(transactionMapper.convertToDtos(transactions), transactions.getNumber(), transactions.getSize(),
                transactions.getTotalElements(), transactions.getTotalPages(), transactions.isLast());

    }




}
