package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.mapper.CourseEnrollmentMapper;
import com.eobrazovanje.university.mapper.StudentMapper;
import com.eobrazovanje.university.mapper.dto.CourseEnrollmentDTO;
import com.eobrazovanje.university.mapper.dto.CourseEnrollmentWIthIndexDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.repository.StudentRepository;
import com.eobrazovanje.university.service.CourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/course-enrollments")
public class CourseEnrollmentController {

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @Autowired
    private CourseEnrollmentMapper courseEnrollmentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;



    @GetMapping
    public PagedResponse<CourseEnrollmentDTO> getCourseEnrollments(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                                         @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
       return courseEnrollmentService.getAllCourseEnrollments(page, size);

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

    @GetMapping(value = "/course/{id}")
    public PagedResponse<CourseEnrollmentDTO> getEnrollmentsByCourse (@PathVariable("id") Long id, @RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                  @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return courseEnrollmentService.getAllTeacherCourseEnrollments(id, page, size);
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

    @PostMapping(value = "/index-number")
    public ResponseEntity<CourseEnrollmentDTO> addCourseEnrollment(@RequestBody CourseEnrollmentWIthIndexDTO courseEnrollmentWIthIndexDTO) {
        Student student = studentRepository.findStudentByIndex(courseEnrollmentWIthIndexDTO.getIndex_number());
        CourseEnrollmentDTO enrollmentDTO = new CourseEnrollmentDTO();
        enrollmentDTO.setId(courseEnrollmentWIthIndexDTO.getId());
        enrollmentDTO.setCourse(courseEnrollmentWIthIndexDTO.getCourse());
        enrollmentDTO.setStudent(studentMapper.convertToDto(student));
        enrollmentDTO.setDeleted(courseEnrollmentWIthIndexDTO.getDeleted());

        Course_enrollment course_enrollment = courseEnrollmentMapper.convertToEntity(enrollmentDTO);
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
            course_enrollment.setId(courseEnrollmentDTO.getId());
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
