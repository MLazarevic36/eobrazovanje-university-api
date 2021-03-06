package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query(value = "SELECT * FROM exams WHERE deleted=0", nativeQuery = true)
    Page<Exam> findAllByDeleted(Pageable pageable);

    Set<Exam> findByDeletedFalse();

//    @Query(value = "SELECT * FROM exams WHERE deleted=0 AND course_id = :courseId ", nativeQuery = true)
    Set<Exam> findByDeletedFalseAndCourse_Id(Long courseId);
}
