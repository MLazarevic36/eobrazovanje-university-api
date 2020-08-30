package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Course;
import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.mapper.CourseMapper;
import com.eobrazovanje.university.mapper.dto.CourseDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.StudentDTO;
import com.eobrazovanje.university.repository.CourseRepository;
import com.eobrazovanje.university.service.interfaces.CourseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CourseService implements CourseInterface {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

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

    public PagedResponse<CourseDTO> getAllCourses(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "course_id");
        Page<Course> courses = courseRepository.findAllByDeleted(pageable);

        if (courses.getNumberOfElements() == 0) {
            return new PagedResponse<CourseDTO>(Collections.emptySet(), courses.getNumber(), courses.getSize(),
                    courses.getTotalElements(), courses.getTotalPages(), courses.isLast());
        }

        return new PagedResponse<CourseDTO>(courseMapper.convertToDtos(courses), courses.getNumber(), courses.getSize(),
                courses.getTotalElements(), courses.getTotalPages(), courses.isLast());


    }
}
