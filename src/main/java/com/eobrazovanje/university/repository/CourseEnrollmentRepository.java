package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Course_enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<Course_enrollment, Long> {
}
