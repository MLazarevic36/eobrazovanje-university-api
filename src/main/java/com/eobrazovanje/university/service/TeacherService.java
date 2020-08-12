package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Teacher;
import com.eobrazovanje.university.repository.TeacherRepository;
import com.eobrazovanje.university.service.interfaces.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements TeacherInterface {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findOne(Long id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacher.setDeleted(true);
        teacherRepository.save(teacher);
    }
}
