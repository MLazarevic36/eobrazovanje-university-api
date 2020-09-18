package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Teacher_engagement;
import com.eobrazovanje.university.mapper.TeacherEngagementMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TeacherEngagementDTO;
import com.eobrazovanje.university.repository.TeacherEngagementRepository;
import com.eobrazovanje.university.service.interfaces.TeacherEngagementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TeacherEngagementService implements TeacherEngagementInterface {

    @Autowired
    private TeacherEngagementRepository teacherEngagementRepository;

    @Autowired
    private TeacherEngagementMapper teacherEngagementMapper;

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

    public Page<Teacher_engagement> getTeachersEngagementsByRole(Long id, Pageable pageable) {
        return teacherEngagementRepository.findAllByDeletedAndTeacherAndRole(id, pageable);
    }

    public PagedResponse<TeacherEngagementDTO> getAllEngagements(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "teacher_engagement_id");

        Page<Teacher_engagement> engagements = teacherEngagementRepository.findAllByDeleted(pageable);

        if (engagements.getNumberOfElements() == 0) {
            return new PagedResponse<TeacherEngagementDTO>(Collections.emptySet(), engagements.getNumber(), engagements.getSize(),
                    engagements.getTotalElements(), engagements.getTotalPages(), engagements.isLast());
        }

        return new PagedResponse<TeacherEngagementDTO>(teacherEngagementMapper.convertToDtos(engagements), engagements.getNumber(), engagements.getSize(),
                engagements.getTotalElements(), engagements.getTotalPages(), engagements.isLast());

    }
}
