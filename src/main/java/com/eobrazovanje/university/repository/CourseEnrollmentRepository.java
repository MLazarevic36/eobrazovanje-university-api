package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Course_enrollment;
import com.eobrazovanje.university.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<Course_enrollment, Long> {

    @Query(value = "SELECT * FROM course_enrollments WHERE deleted = 0 AND student_id = :student_id", nativeQuery = true)
    Page<Course_enrollment> findAllByDeletedByStudent(@Param("student_id") Long student_id, Pageable pageable);

    @Query(value = "SELECT * FROM course_enrollments WHERE deleted = 0", nativeQuery = true)
    Page<Course_enrollment> findAllByDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM course_enrollments WHERE deleted = 0 AND course_id = :course_id", nativeQuery = true)
    Page<Course_enrollment> findAllByCourse(@Param("course_id") Long course_id, Pageable pageable);

}
