package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.Teacher_engagement;
import com.eobrazovanje.university.mapper.TeacherEngagementMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TeacherEngagementDTO;
import com.eobrazovanje.university.service.TeacherEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/teacher-engagements")
public class TeacherEngagementController {

    @Autowired
    private TeacherEngagementService teacherEngagementService;

    @Autowired
    private TeacherEngagementMapper teacherEngagementMapper;

    @GetMapping
    public PagedResponse<TeacherEngagementDTO> getTeacherEngagements(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                                     @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return teacherEngagementService.getAllEngagements(page, size);
    }

    @GetMapping(value = "/professor/{id}")
    public ResponseEntity<Set<TeacherEngagementDTO>> getTeacherEngagementsByRole(Pageable pageable, @PathVariable("id") Long id) {
        try {
            Page<Teacher_engagement> engagements = teacherEngagementService.getTeachersEngagementsByRole(id, pageable);
            return new ResponseEntity<>(teacherEngagementMapper.convertToDtos(engagements),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<TeacherEngagementDTO> getTeacherEngagement(@PathVariable("id") Long id){
        try {
            Teacher_engagement teacher_engagement = teacherEngagementService.findOne(id);
            return new ResponseEntity<>(teacherEngagementMapper.convertToDto(teacher_engagement), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TeacherEngagementDTO> addTeacherEngagement(@RequestBody TeacherEngagementDTO teacherEngagementDTO) {
        Teacher_engagement teacher_engagement = teacherEngagementMapper.convertToEntity(teacherEngagementDTO);
        try {
            teacher_engagement = teacherEngagementService.save(teacher_engagement);
            return new ResponseEntity<>(teacherEngagementMapper.convertToDto(teacher_engagement), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<TeacherEngagementDTO> updateTeacherEngagement(@RequestBody TeacherEngagementDTO teacherEngagementDTO) {
        Teacher_engagement teacher_engagement = teacherEngagementMapper.convertToEntity(teacherEngagementDTO);
        try {
            teacher_engagement.setId(teacherEngagementDTO.getId());
            teacher_engagement = teacherEngagementService.save(teacher_engagement);
            return new ResponseEntity<>(teacherEngagementMapper.convertToDto(teacher_engagement), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTeacherEngagement(@PathVariable("id") Long id) {
        try {
            Teacher_engagement teacher_engagement = teacherEngagementService.findOne(id);
            teacherEngagementService.delete(teacher_engagement);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
