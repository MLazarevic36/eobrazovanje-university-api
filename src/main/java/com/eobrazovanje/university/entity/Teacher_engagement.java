package com.eobrazovanje.university.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher_engagements")
public class Teacher_engagement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_engagement_id", unique = true, nullable = false)
    private Long teacher_engagement_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    @Column(name = "teacher_role", nullable = false)
    private Teacher_role teacher_role;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean deleted;

    public Teacher_engagement() {
    }

    public Long getTeacher_engagement_id() {
        return teacher_engagement_id;
    }

    public void setTeacher_engagement_id(Long teacher_engagement_id) {
        this.teacher_engagement_id = teacher_engagement_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher_role getTeacher_role() {
        return teacher_role;
    }

    public void setTeacher_role(Teacher_role teacher_role) {
        this.teacher_role = teacher_role;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
