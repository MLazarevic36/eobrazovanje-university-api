package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.Teacher_engagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherEngagementRepository extends JpaRepository<Teacher_engagement, Long> {

    @Query(value = "SELECT * FROM teacher_engagements WHERE deleted=0 AND teacher_id = :teacher_id", nativeQuery = true)
    Page<Teacher_engagement> findAllByDeletedAndTeacher(@Param("teacher_id") Long teacher_id, Pageable pageable);

    @Query(value = "SELECT * FROM teacher_engagements WHERE deleted=0", nativeQuery = true)
    Page<Teacher_engagement> findAllByDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM teacher_engagements WHERE deleted=0 AND teacher_id = :teacher_id AND " +
            "teacher_role = 'PROFESSOR'", nativeQuery = true)
    Page<Teacher_engagement> findAllByDeletedAndTeacherAndRole(@Param("teacher_id") Long teacher_id, Pageable pageable);
}
