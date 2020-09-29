package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.*;
import com.eobrazovanje.university.mapper.ExamRegistrationMapper;
import com.eobrazovanje.university.mapper.TeacherMapper;
import com.eobrazovanje.university.mapper.UserMapper;
import com.eobrazovanje.university.mapper.dto.*;
import com.eobrazovanje.university.repository.UserRepository;
import com.eobrazovanje.university.service.TeacherService;
import com.eobrazovanje.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ExamRegistrationMapper examRegistrationMapper;

    @GetMapping
    public PagedResponse<TeacherDTO> getTeachers(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                 @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return teacherService.getAllTeachers(page, size);
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

    @GetMapping(value = "/{id}/engagements")
    public PagedResponse<TeacherEngagementDTO> getTeacherEngagements(@PathVariable("id") Long id, @RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                                     @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        return teacherService.getAllTeacherEngagements(id, page, size);
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        User user = userRepository.getOne(teacherDTO.getUser().getId());
        teacherDTO.setUser(userMapper.convertToDto(user));
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
        User user = userMapper.convertToEntity(teacherDTO.getUser());
        try {
            teacher.setId(teacherDTO.getId());
            user.setId(teacherDTO.getUser().getId());
            userService.save(user);
            teacherService.save(teacher);
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

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<TeacherDTO> getTeacherByUser(@PathVariable("id") Long id){
        try {
            Teacher teacher = teacherService.getTeacherByUser(id);
            return new ResponseEntity<>(teacherMapper.convertToDto(teacher), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}/exams")
    public PagedResponse<ExamRegistrationDTO> getTeacherExams(@PathVariable("id") Long id, @RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                                    @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){

        return teacherService.getTeacherExams(id, page, size);

    }


}
