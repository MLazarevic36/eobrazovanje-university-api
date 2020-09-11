package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.*;
import com.eobrazovanje.university.mapper.ExamRegistrationMapper;
import com.eobrazovanje.university.mapper.TeacherEngagementMapper;
import com.eobrazovanje.university.mapper.TeacherMapper;
import com.eobrazovanje.university.mapper.dto.ExamRegistrationDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TeacherDTO;
import com.eobrazovanje.university.mapper.dto.TeacherEngagementDTO;
import com.eobrazovanje.university.repository.ExamRegistrationRepository;
import com.eobrazovanje.university.repository.TeacherEngagementRepository;
import com.eobrazovanje.university.repository.TeacherRepository;
import com.eobrazovanje.university.service.interfaces.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherService implements TeacherInterface {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ExamRegistrationRepository examRegistrationRepository;

    @Autowired
    private TeacherEngagementRepository teacherEngagementRepository;

    @Autowired
    private TeacherEngagementMapper teacherEngagementMapper;

    @Autowired
    private ExamRegistrationMapper examRegistrationMapper;

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

    public PagedResponse<TeacherEngagementDTO> getAllTeacherEngagements(Long id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "teacher_engagement_id");
        Page<Teacher_engagement> teacher_engagements = teacherEngagementRepository.findAllByDeletedAndTeacher(id, pageable);

        if (teacher_engagements.getNumberOfElements() == 0) {
            return new PagedResponse<TeacherEngagementDTO>(Collections.emptySet(), teacher_engagements.getNumber(), teacher_engagements.getSize(),
                    teacher_engagements.getTotalElements(), teacher_engagements.getTotalPages(), teacher_engagements.isLast());
        }

        return new PagedResponse<TeacherEngagementDTO>(teacherEngagementMapper.convertToDtos(teacher_engagements), teacher_engagements.getNumber(), teacher_engagements.getSize(),
                teacher_engagements.getTotalElements(), teacher_engagements.getTotalPages(), teacher_engagements.isLast());

    }

    public Teacher getTeacherByUser(Long id) {
        return teacherRepository.findTeacherByUser(id);
    }

    public PagedResponse<ExamRegistrationDTO> getTeacherExams(Long id, int page, int size) {
        Set<ExamRegistration> exams = new HashSet<>();
        Set<ExamRegistration> all_exams = examRegistrationRepository.findAllByDeletedSet();
        Teacher_engagement t = teacherEngagementRepository.getOne(id);
        for(ExamRegistration e : all_exams) {
            if(e.getExam().getCourse().getCourse_id() == t.getCourse().getCourse_id()) {
                exams.add(e);
            }
        }
        List<ExamRegistration> list_exams = new ArrayList<>(exams);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "exam_registration_id");
        Page<ExamRegistration> pageExams = new PageImpl<ExamRegistration>(list_exams, pageable, list_exams.size());

        if (pageExams.getNumberOfElements() == 0) {
            return new PagedResponse<ExamRegistrationDTO>(Collections.emptySet(), pageExams.getNumber(), pageExams.getSize(),
                    pageExams.getTotalElements(), pageExams.getTotalPages(), pageExams.isLast());
        }

        return new PagedResponse<ExamRegistrationDTO>(examRegistrationMapper.convertToDtos(pageExams), pageExams.getNumber(), pageExams.getSize(),
                pageExams.getTotalElements(), pageExams.getTotalPages(), pageExams.isLast());
    }


}
