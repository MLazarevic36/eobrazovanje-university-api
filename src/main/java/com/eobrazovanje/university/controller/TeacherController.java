package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.Teacher;
import com.eobrazovanje.university.mapper.TeacherMapper;
import com.eobrazovanje.university.mapper.dto.TeacherDTO;
import com.eobrazovanje.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping
    public ResponseEntity<Set<TeacherDTO>> getTeachers(Pageable pageable) {
        try {
            Page<Teacher> teachers = teacherService.findAll(pageable);
            return new ResponseEntity<>(teacherMapper.convertToDtos(teachers),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeacherDTO> getTeacher(@PathVariable("id") Long id){
        try {
            Teacher teacher = teacherService.findOne(id);
            return new ResponseEntity<>(teacherMapper.convertToDto(teacher), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.convertToEntity(teacherDTO);
        try {
            teacher = teacherService.save(teacher);
            return new ResponseEntity<>(teacherMapper.convertToDto(teacher), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.convertToEntity(teacherDTO);
        try {
            teacher.setId(teacherDTO.getId());
            teacher = teacherService.save(teacher);
            return new ResponseEntity<>(teacherMapper.convertToDto(teacher), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Long id) {
        try {
            Teacher teacher = teacherService.findOne(id);
            teacherService.delete(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
