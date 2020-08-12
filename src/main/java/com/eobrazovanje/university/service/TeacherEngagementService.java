package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Teacher_engagement;
import com.eobrazovanje.university.repository.TeacherEngagementRepository;
import com.eobrazovanje.university.service.interfaces.TeacherEngagementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherEngagementService implements TeacherEngagementInterface {

    @Autowired
    private TeacherEngagementRepository teacherEngagementRepository;

    @Override
    public Teacher_engagement findOne(Long id) {
        return teacherEngagementRepository.getOne(id);
    }

    @Override
    public Page<Teacher_engagement> findAll(Pageable pageable) {
        return teacherEngagementRepository.findAll(pageable);
    }

    @Override
    public Teacher_engagement save(Teacher_engagement teacher_engagement) {
        return teacherEngagementRepository.save(teacher_engagement);
    }

    @Override
    public Teacher_engagement update(Teacher_engagement teacher_engagement) {
        return teacherEngagementRepository.save(teacher_engagement);
    }

    @Override
    public void delete(Teacher_engagement teacher_engagement) {
        teacher_engagement.setDeleted(true);
        teacherEngagementRepository.save(teacher_engagement);
    }
}
