package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.repository.CourseEnrollmentRepository;
import com.eobrazovanje.university.service.interfaces.CourseEnrollmentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseEnrollmentService implements CourseEnrollmentInterface {

    @Autowired
    private CourseEnrollmentRepository courseEnrollmentRepository;

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
}
