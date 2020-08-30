package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM courses WHERE deleted = 0", nativeQuery = true)
    Page<Course> findAllByDeleted(Pageable pageable);
}
