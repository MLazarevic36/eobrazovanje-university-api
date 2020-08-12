package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Teacher_engagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherEngagementInterface {

    Teacher_engagement findOne(Long id);
    Page<Teacher_engagement> findAll(Pageable pageable);
    Teacher_engagement save(Teacher_engagement teacher_engagement);
    Teacher_engagement update(Teacher_engagement teacher_engagement);
    void delete(Teacher_engagement teacher_engagement);

}
