package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseInterface {

    Course findOne(Long id);
    Page<Course> findAll(Pageable pageable);
    Course save(Course course);
    Course update(Course course);
    void delete(Course course);
}
