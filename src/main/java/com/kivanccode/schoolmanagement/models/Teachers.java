package com.kivanccode.schoolmanagement.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teacher_number")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TeacherNumber")
    private int TeacherNumber;

    private String TeacherName;

    private String GraduationSchool;

    private String GraduationDate;

    private String TechnicalTitle;

    private String FinalDegree;

    private String MobilePhone;

    private String ElectronicMailbox;

//    @ManyToMany(mappedBy = "Teach")
//    Set<Courses> course;

    @OneToMany(mappedBy = "teachers")
    Set<Teach> teach;
}
