package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.entity.User;
import com.eobrazovanje.university.mapper.StudentMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.StudentDTO;
import com.eobrazovanje.university.mapper.dto.UserDTO;
import com.eobrazovanje.university.repository.StudentRepository;
import com.eobrazovanje.university.repository.UserRepository;
import com.eobrazovanje.university.service.interfaces.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class StudentService implements StudentInterface {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

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

    public PagedResponse<StudentDTO> getAllStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "student_id");
        Page<Student> students = studentRepository.findAllByDeleted(pageable);

        if (students.getNumberOfElements() == 0) {
            return new PagedResponse<StudentDTO>(Collections.emptySet(), students.getNumber(), students.getSize(),
                    students.getTotalElements(), students.getTotalPages(), students.isLast());
        }

        return new PagedResponse<StudentDTO>(studentMapper.convertToDtos(students), students.getNumber(), students.getSize(),
                students.getTotalElements(), students.getTotalPages(), students.isLast());

    }
}
