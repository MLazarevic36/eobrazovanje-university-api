package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.Course;
import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.mapper.CourseMapper;
import com.eobrazovanje.university.mapper.dto.CourseDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping
    public PagedResponse<CourseDTO> getCourses (@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return courseService.getAllCourses(page,size);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable("id") Long id){
        try {
            Course course = courseService.findOne(id);
            return new ResponseEntity<>(courseMapper.convertToDto(course), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.convertToEntity(courseDTO);
        try {
            course = courseService.save(course);
            return new ResponseEntity<>(courseMapper.convertToDto(course), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.convertToEntity(courseDTO);
        try {
            course.setCourse_id(courseDTO.getCourse_id());
            course = courseService.save(course);
            return new ResponseEntity<>(courseMapper.convertToDto(course), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") Long id) {
        try {
            Course course = courseService.findOne(id);
            courseService.delete(course);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



}
