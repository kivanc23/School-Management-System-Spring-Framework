package com.kivanccode.schoolmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
public class Teach {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CourseNumber")
    Courses courses;


    @ManyToOne
    @JoinColumn(name = "TeacherNumber")
    Teachers teachers;

    public Teach() {

    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    public Teach(Integer id, Courses courses, Teachers teachers) {
        this.id = id;
        this.courses = courses;
        this.teachers = teachers;
    }
}
