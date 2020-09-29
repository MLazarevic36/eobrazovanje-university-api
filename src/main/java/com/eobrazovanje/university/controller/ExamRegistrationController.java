package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.*;
import com.eobrazovanje.university.mapper.ExamMapper;
import com.eobrazovanje.university.mapper.ExamRegistrationMapper;
import com.eobrazovanje.university.mapper.StudentMapper;
import com.eobrazovanje.university.mapper.dto.ExamRegistrationDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.repository.ExamRepository;
import com.eobrazovanje.university.repository.StudentRepository;
import com.eobrazovanje.university.service.ExamRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/exam-registrations")
public class ExamRegistrationController {

    @Autowired
    private ExamRegistrationService examRegistrationService;

    @Autowired
    private ExamRegistrationMapper examRegistrationMapper;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public PagedResponse<ExamRegistrationDTO> getExamsRegistrations(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                           @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {

        return examRegistrationService.getAllExamRegistrations(page, size);
    }

    @GetMapping(value = "/student/{id}")
    public PagedResponse<ExamRegistrationDTO> getExamRegistrationsByStudent(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                       @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size, @PathVariable("id") Long id) {

        return examRegistrationService.getAllExamRegistrationsByStudent(id, page, size);
    }

    @GetMapping(value = "/student/passed/{id}")
    public PagedResponse<ExamRegistrationDTO> getExamRegistrationsByStudentPassed(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                                            @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size, @PathVariable("id") Long id) {

        return examRegistrationService.getAllExamRegistrationsByStudentPassed(id, page, size);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExamRegistrationDTO> getExamRegistration(@PathVariable("id") Long id){
        try {
            ExamRegistration examRegistration = examRegistrationService.findOne(id);
            return new ResponseEntity<>(examRegistrationMapper.convertToDto(examRegistration), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ExamRegistrationDTO> addExamRegistration(@RequestBody ExamRegistrationDTO examRegistrationDTO) {
        Exam exam = examRepository.getOne(examRegistrationDTO.getExam().getId());
        examRegistrationDTO.setExam(examMapper.convertToDto(exam));
        ExamRegistration examRegistration = examRegistrationMapper.convertToEntity(examRegistrationDTO);
        try {
            examRegistration = examRegistrationService.save(examRegistration);
            return new ResponseEntity<>(examRegistrationMapper.convertToDto(examRegistration), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<ExamRegistrationDTO> updateExamRegistration(@RequestBody ExamRegistrationDTO examRegistrationDTO) {
        ExamRegistration examRegistration = examRegistrationMapper.convertToEntity(examRegistrationDTO);
        try {
            examRegistration.setId(examRegistrationDTO.getId());
            examRegistration = examRegistrationService.update(examRegistration);
            return new ResponseEntity<>(examRegistrationMapper.convertToDto(examRegistration), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteExamRegistration(@PathVariable("id") Long id) {
        try {
            ExamRegistration examRegistration = examRegistrationService.findOne(id);
            examRegistrationService.delete(examRegistration);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
