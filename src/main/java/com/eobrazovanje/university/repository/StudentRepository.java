package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM students WHERE deleted = 0", nativeQuery = true)
    Page<Student> findAllByDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM students WHERE user_id = :id", nativeQuery = true)
    Student findStudentByUser(@Param("id") Long id);

}
