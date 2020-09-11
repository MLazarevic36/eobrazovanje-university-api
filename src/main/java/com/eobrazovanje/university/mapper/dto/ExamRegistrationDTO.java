package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Status;
import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.mapper.StudentMapper;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ExamRegistrationDTO implements Serializable {

    private Long exam_registration_id;
    private int colloquium_points;
    private int exam_points;
    private int grade;
    private Status status;
//
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "exam_id",
//            scope = ExamDTO.class)
//    @JsonIdentityReference(alwaysAsId = true)
//    @JsonBackReference(value = "exams-exam-registrations")
    private ExamDTO exam;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "student_id",
//            scope = StudentDTO.class)
//    @JsonIdentityReference(alwaysAsId = true)
//    @JsonBackReference(value = "student-exam-registrations")
    private StudentDTO student;

//    private StudentInfo studentInfo;

    private Boolean registered;
    private Boolean deleted;

    public ExamRegistrationDTO() {
    }

    public ExamRegistrationDTO(Long exam_registration_id, int colloquium_points, int exam_points, int grade, Status status,
                               ExamDTO exam, StudentDTO student, Boolean registered, Boolean deleted) {
        this.exam_registration_id = exam_registration_id;
        this.colloquium_points = colloquium_points;
        this.exam_points = exam_points;
        this.grade = grade;
        this.status = status;
        this.exam = exam;
        this.student = student;
        this.registered = registered;
        this.deleted = deleted;
    }

    public Long getExam_registration_id() {
        return exam_registration_id;
    }

    public void setExam_registration_id(Long exam_registration_id) {
        this.exam_registration_id = exam_registration_id;
    }

    public int getColloquium_points() {
        return colloquium_points;
    }

    public void setColloquium_points(int colloquium_points) {
        this.colloquium_points = colloquium_points;
    }

    public int getExam_points() {
        return exam_points;
    }

    public void setExam_points(int exam_points) {
        this.exam_points = exam_points;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}
