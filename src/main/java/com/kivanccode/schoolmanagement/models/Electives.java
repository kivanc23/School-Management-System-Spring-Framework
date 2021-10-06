package com.kivanccode.schoolmanagement.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class Electives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "StudentNumber")
    Students student;

    @ManyToOne
    @JoinColumn(name = "CourseNumber")
    Courses courses;
}
