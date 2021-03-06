package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.entity.Teacher;
import com.eobrazovanje.university.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT * FROM teachers WHERE deleted = 0", nativeQuery = true)
    Page<Teacher> findAllByDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM teachers WHERE user_id = :id", nativeQuery = true)
    Teacher findTeacherByUser(@Param("id") Long id);

}
