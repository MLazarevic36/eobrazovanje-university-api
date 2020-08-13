package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.mapper.StudentMapper;
import com.eobrazovanje.university.mapper.dto.StudentDTO;
import com.eobrazovanje.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<Set<StudentDTO>> getStudents(Pageable pageable) {
        try {
            Page<Student> students = studentService.findAll(pageable);
            return new ResponseEntity<>(studentMapper.convertToDtos(students),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id){
        try {
            Student student = studentService.findOne(id);
            return new ResponseEntity<>(studentMapper.convertToDto(student), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.convertToEntity(studentDTO);
        try {
            student = studentService.save(student);
            return new ResponseEntity<>(studentMapper.convertToDto(student), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.convertToEntity(studentDTO);
        try {
            student.setId(studentDTO.getId());
            student = studentService.save(student);
            return new ResponseEntity<>(studentMapper.convertToDto(student), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        try {
            Student student = studentService.findOne(id);
            studentService.delete(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
