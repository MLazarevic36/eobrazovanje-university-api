package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.repository.StudentRepository;
import com.eobrazovanje.university.service.interfaces.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentInterface {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findOne(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        student.setDeleted(true);
        studentRepository.save(student);
    }
}
