package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Exam;
import com.eobrazovanje.university.entity.ExamRegistration;
import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Long> {

    @Query(value = "SELECT * FROM exam_registrations WHERE deleted = 0", nativeQuery = true)
    Page<ExamRegistration> findAllByDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM exam_registrations WHERE deleted=0 AND status = 'ACTIVE'", nativeQuery = true)
    Set<ExamRegistration> findAllByDeletedSet();

    @Query(value = "SELECT * FROM exam_registrations WHERE deleted=0 AND status = 'ACTIVE' AND student = :student_id", nativeQuery = true)
    Set<ExamRegistration> findAllByStudentSet(@Param("student_id") Long student_id);

    @Query(value = "SELECT * FROM exam_registrations WHERE deleted=0 AND student = :student_id", nativeQuery = true)
    Page<ExamRegistration> findAllByStudentAndRegistered(@Param("student_id") Long student_id, Pageable pageable);

    @Query(value = "SELECT * FROM exam_registrations WHERE deleted=0 AND student = :student_id AND status = 'ACTIVE'", nativeQuery = true)
    Page<ExamRegistration> findAllByStudentForUnregister(@Param("student_id") Long student_id, Pageable pageable);

    @Query(value = "SELECT * FROM exam_registrations WHERE deleted=0 AND student = :student_id AND status = 'PASSED'", nativeQuery = true)
    Page<ExamRegistration> findAllByStudentAndPassed(@Param("student_id") Long student_id, Pageable pageable);

}
