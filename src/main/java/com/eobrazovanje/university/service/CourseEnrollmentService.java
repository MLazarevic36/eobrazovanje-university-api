package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.mapper.CourseEnrollmentMapper;
import com.eobrazovanje.university.mapper.dto.CourseEnrollmentDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.repository.CourseEnrollmentRepository;
import com.eobrazovanje.university.service.interfaces.CourseEnrollmentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CourseEnrollmentService implements CourseEnrollmentInterface {

    @Autowired
    private CourseEnrollmentRepository courseEnrollmentRepository;

    @Autowired
    private CourseEnrollmentMapper courseEnrollmentMapper;

    @Override
    public Course_enrollment findOne(Long id) {
        return courseEnrollmentRepository.getOne(id);
    }

    @Override
    public Page<Course_enrollment> findAll(Pageable pageable) {
        return courseEnrollmentRepository.findAll(pageable);
    }

    @Override
    public Course_enrollment save(Course_enrollment course_enrollment) {
        return courseEnrollmentRepository.save(course_enrollment);
    }

    @Override
    public Course_enrollment update(Course_enrollment course_enrollment) {
        return courseEnrollmentRepository.save(course_enrollment);
    }

    @Override
    public void delete(Course_enrollment course_enrollment) {
        course_enrollment.setDeleted(true);
        courseEnrollmentRepository.save(course_enrollment);
    }

    public PagedResponse<CourseEnrollmentDTO> getAllTeacherCourseEnrollments(Long id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "course_enrollment_id");

        Page<Course_enrollment> enrollments = courseEnrollmentRepository.findAllByCourse(id, pageable);

        if (enrollments.getNumberOfElements() == 0) {
            return new PagedResponse<CourseEnrollmentDTO>(Collections.emptySet(), enrollments.getNumber(), enrollments.getSize(),
                    enrollments.getTotalElements(), enrollments.getTotalPages(), enrollments.isLast());
        }

        return new PagedResponse<CourseEnrollmentDTO>(courseEnrollmentMapper.convertToDtos(enrollments), enrollments.getNumber(), enrollments.getSize(),
                enrollments.getTotalElements(), enrollments.getTotalPages(), enrollments.isLast());

    }

    public PagedResponse<CourseEnrollmentDTO> getAllCourseEnrollments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "course_enrollment_id");

        Page<Course_enrollment> enrollments = courseEnrollmentRepository.findAllByDeleted(pageable);

        if (enrollments.getNumberOfElements() == 0) {
            return new PagedResponse<CourseEnrollmentDTO>(Collections.emptySet(), enrollments.getNumber(), enrollments.getSize(),
                    enrollments.getTotalElements(), enrollments.getTotalPages(), enrollments.isLast());
        }

        return new PagedResponse<CourseEnrollmentDTO>(courseEnrollmentMapper.convertToDtos(enrollments), enrollments.getNumber(), enrollments.getSize(),
                enrollments.getTotalElements(), enrollments.getTotalPages(), enrollments.isLast());

    }



}
