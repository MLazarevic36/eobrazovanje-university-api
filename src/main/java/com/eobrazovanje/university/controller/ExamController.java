package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.mapper.ExamMapper;
import com.eobrazovanje.university.mapper.dto.ExamDTO;
import com.eobrazovanje.university.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamMapper examMapper;

    @GetMapping
    public ResponseEntity<Set<ExamDTO>> getExams(Pageable pageable) {
        try {
            Page<Exam> exams = examService.findAll(pageable);
            return new ResponseEntity<>(examMapper.convertToDtos(exams),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExamDTO> getExam(@PathVariable("id") Long id){
        try {
            Exam exam = examService.findOne(id);
            return new ResponseEntity<>(examMapper.convertToDto(exam), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDTO) {
        Exam exam = examMapper.convertToEntity(examDTO);
        try {
            exam = examService.save(exam);
            return new ResponseEntity<>(examMapper.convertToDto(exam), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO) {
        Exam exam = examMapper.convertToEntity(examDTO);
        try {
            exam.setId(examDTO.getId());
            exam = examService.save(exam);
            return new ResponseEntity<>(examMapper.convertToDto(exam), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable("id") Long id) {
        try {
            Exam exam = examService.findOne(id);
            examService.delete(exam);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
