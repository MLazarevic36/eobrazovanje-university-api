package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Teacher;
import com.eobrazovanje.university.mapper.TeacherMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TeacherDTO;
import com.eobrazovanje.university.repository.TeacherRepository;
import com.eobrazovanje.university.service.interfaces.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TeacherService implements TeacherInterface {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

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

    public PagedResponse<TeacherDTO> getAllTeachers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "teacher_id");
        Page<Teacher> teachers = teacherRepository.findAllByDeleted(pageable);

        if (teachers.getNumberOfElements() == 0) {
            return new PagedResponse<TeacherDTO>(Collections.emptySet(), teachers.getNumber(), teachers.getSize(),
                    teachers.getTotalElements(), teachers.getTotalPages(), teachers.isLast());
        }

        return new PagedResponse<TeacherDTO>(teacherMapper.convertToDtos(teachers), teachers.getNumber(), teachers.getSize(),
                teachers.getTotalElements(), teachers.getTotalPages(), teachers.isLast());

    }
}
