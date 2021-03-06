package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.mapper.dto.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO convertToDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    public Set<StudentDTO> convertToDtos(Page<Student> studentPage) {
        return studentPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Student convertToEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

    public Set<Student> convertToEntities(Collection<StudentDTO> studentDTOS) {
        return studentDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }
//
//    public TypeMap<StudentInfo, Student> mapStudentInfo(StudentInfo studentInfo, Student student) {
//
//        PropertyMap<StudentInfo, Student> studentMap = new PropertyMap<StudentInfo, Student>() {
//
//            @Override
//            protected void configure() {
//                map().getStudent_id(source.getStudent_id());
//                map().getFirst_name(source.getFirst_name());
//                map().getLast_name(source.getLast_name());
//                map().getIndex_number(source.getIndex_number());
//            }
//
//        };
//        return  modelMapper.addMappings(studentMap);
//    }



}
