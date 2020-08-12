package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Course_enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseEnrollmentInterface {

    Course_enrollment findOne(Long id);
    Page<Course_enrollment> findAll(Pageable pageable);
    Course_enrollment save(Course_enrollment course_enrollment);
    Course_enrollment update(Course_enrollment course_enrollment);
    void delete(Course_enrollment course_enrollment);
}
