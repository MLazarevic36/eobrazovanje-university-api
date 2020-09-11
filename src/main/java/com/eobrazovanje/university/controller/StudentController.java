package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.*;
import com.eobrazovanje.university.mapper.*;
import com.eobrazovanje.university.mapper.dto.*;
import com.eobrazovanje.university.repository.UserRepository;
import com.eobrazovanje.university.service.StudentService;
import com.eobrazovanje.university.service.TermService;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseEnrollmentMapper courseEnrollmentMapper;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private TermService termService;

    @Autowired
    private TermMapper termMapper;

    @GetMapping
    public PagedResponse<StudentDTO> getStudents (@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                  @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return studentService.getAllStudents(page,size);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id){
        try {
            Student student = studentService.findOne(id);
            return new ResponseEntity<>(studentMapper.convertToDto(student), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<StudentDTO> getStudentByUser(@PathVariable("id") Long id){
        try {
            Student student = studentService.getStudentByUser(id);
            return new ResponseEntity<>(studentMapper.convertToDto(student), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}/enrollments")
    public PagedResponse<CourseEnrollmentDTO> getStudentEnrollments(@PathVariable("id") Long id, @RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                                    @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        return studentService.getAllStudentEnrollments(id, page, size);
    }

    @GetMapping(value = "/{id}/transactions")
    public PagedResponse<TransactionDTO> getStudentTransactions(@PathVariable("id") Long id, @RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                             @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        return studentService.getAllStudentTransactions(id, page, size);
    }

    @GetMapping(value = "/{id}/exams")
    public ResponseEntity<Set<ExamDTO>> getStudentExams(@PathVariable("id") Long id){
        try {
            Set<Exam> exams = studentService.getStudentExams(id);
            return new ResponseEntity<>(examMapper.convertToDtosSet(exams), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}/terms")
    public ResponseEntity<Set<TermDTO>> getStudentTerms(@PathVariable("id") Long id){

        try {
            Set<Term> terms = termService.getAllTermsForStudentNotRegisteredExams(id);
            return new ResponseEntity<>(termMapper.convertToDtosSet(terms), HttpStatus.OK);

        }catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        User user = userRepository.getOne(studentDTO.getUser().getId());
        studentDTO.setUser(userMapper.convertToDto(user));
        Student student = studentMapper.convertToEntity(studentDTO);
        try {
            student = studentService.save(student);
            return new ResponseEntity<>(studentMapper.convertToDto(student), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.convertToEntity(studentDTO);
        try {
            student.setStudent_id(studentDTO.getStudent_id());
            student = studentService.save(student);
            return new ResponseEntity<>(studentMapper.convertToDto(student), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        try {
            Student student = studentService.findOne(id);
            studentService.delete(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
