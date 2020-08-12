package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Course;
import com.eobrazovanje.university.repository.CourseRepository;
import com.eobrazovanje.university.service.interfaces.CourseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements CourseInterface {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course findOne(Long id) {
        return courseRepository.getOne(id);
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(Course course) {
        course.setDeleted(true);
        courseRepository.save(course);
    }
}
