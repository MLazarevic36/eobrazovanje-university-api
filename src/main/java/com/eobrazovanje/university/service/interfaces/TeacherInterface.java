package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherInterface {

    Teacher findOne(Long id);
    Page<Teacher> findAll(Pageable pageable);
    Teacher save(Teacher teacher);
    Teacher update(Teacher teacher);
    void delete(Teacher teacher);

}
