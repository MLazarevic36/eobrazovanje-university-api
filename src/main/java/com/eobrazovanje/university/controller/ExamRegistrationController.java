package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.mapper.ExamRegistrationMapper;
import com.eobrazovanje.university.mapper.dto.ExamRegistrationDTO;
import com.eobrazovanje.university.service.ExamRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/exam-registrations")
public class ExamRegistrationController {

    @Autowired
    private ExamRegistrationService examRegistrationService;

    @Autowired
    private ExamRegistrationMapper examRegistrationMapper;

    @GetMapping
    public ResponseEntity<Set<ExamRegistrationDTO>> getExamRegistrations(Pageable pageable) {
        try {
            Page<ExamRegistration> examRegistrations = examRegistrationService.findAll(pageable);
            return new ResponseEntity<>(examRegistrationMapper.convertToDtos(examRegistrations),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
            examRegistration = examRegistrationService.save(examRegistration);
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
