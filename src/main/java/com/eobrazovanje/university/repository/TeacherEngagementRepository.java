package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Teacher_engagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherEngagementRepository extends JpaRepository<Teacher_engagement, Long> {

}
