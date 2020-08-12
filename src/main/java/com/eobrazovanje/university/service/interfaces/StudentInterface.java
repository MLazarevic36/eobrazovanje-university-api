package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentInterface {

    Student findOne(Long id);
    Page<Student> findAll(Pageable pageable);
    Student save(Student student);
    Student update(Student student);
    void delete(Student student);

}
