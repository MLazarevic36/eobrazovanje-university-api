package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.mapper.CourseEnrollmentMapper;
import com.eobrazovanje.university.mapper.dto.CourseEnrollmentDTO;
import com.eobrazovanje.university.service.CourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/course-enrollments")
public class CourseEnrollmentController {

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @Autowired
    private CourseEnrollmentMapper courseEnrollmentMapper;

    @GetMapping
    public ResponseEntity<Set<CourseEnrollmentDTO>> getCourseEnrollments(Pageable pageable) {
        try {
            Page<Course_enrollment> courseEnrollments = courseEnrollmentService.findAll(pageable);
            return new ResponseEntity<>(courseEnrollmentMapper.convertToDtos(courseEnrollments),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseEnrollmentDTO> getCourseEnrollment(@PathVariable("id") Long id){
        try {
            Course_enrollment course_enrollment = courseEnrollmentService.findOne(id);
            return new ResponseEntity<>(courseEnrollmentMapper.convertToDto(course_enrollment), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CourseEnrollmentDTO> addCourseEnrollment(@RequestBody CourseEnrollmentDTO courseEnrollmentDTO) {
        Course_enrollment course_enrollment = courseEnrollmentMapper.convertToEntity(courseEnrollmentDTO);
        try {
            course_enrollment = courseEnrollmentService.save(course_enrollment);
            return new ResponseEntity<>(courseEnrollmentMapper.convertToDto(course_enrollment), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<CourseEnrollmentDTO> updateCourseEnrollment(@RequestBody CourseEnrollmentDTO courseEnrollmentDTO) {
        Course_enrollment course_enrollment = courseEnrollmentMapper.convertToEntity(courseEnrollmentDTO);
        try {
            course_enrollment.setCourse_enrollment_id(courseEnrollmentDTO.getCourse_enrollment_id());
            course_enrollment = courseEnrollmentService.save(course_enrollment);
            return new ResponseEntity<>(courseEnrollmentMapper.convertToDto(course_enrollment), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCourseEnrollment(@PathVariable("id") Long id) {
        try {
            Course_enrollment course_enrollment = courseEnrollmentService.findOne(id);
            courseEnrollmentService.delete(course_enrollment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
