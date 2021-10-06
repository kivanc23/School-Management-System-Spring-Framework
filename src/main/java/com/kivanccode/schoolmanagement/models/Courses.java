package com.kivanccode.schoolmanagement.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "CourseNumber")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseNumber")
    private Integer CourseNumber;

    private String CourseName;

    private String CourseNature;

    private char OpenSemester;

    private double CourseCredit;

    private int TheoreticalHours;

    private  int ExperimentHours;

    private String CourseDescription;

    public Courses(Integer courseNumber, String courseName, String courseNature, char openSemester, double courseCredit, int theoreticalHours, int experimentHours, String courseDescription) {
        CourseNumber = courseNumber;
        CourseName = courseName;
        CourseNature = courseNature;
        OpenSemester = openSemester;
        CourseCredit = courseCredit;
        TheoreticalHours = theoreticalHours;
        ExperimentHours = experimentHours;
        CourseDescription = courseDescription;
    }

//    @ManyToMany
//    @JoinTable(name = "Teach", joinColumns = @JoinColumn(name = "CourseNumber"), inverseJoinColumns = @JoinColumn(name = "TeacherNumber"))
//    Set<Teachers> Teach;
//
//    @ManyToMany
//    @JoinTable(name = "Electives", joinColumns = @JoinColumn(name = "CourseNumber"), inverseJoinColumns = @JoinColumn(name = "StudentNumber"))
//    Set<Students> Electives;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "courses",cascade = CascadeType.ALL)
    @Fetch(value= FetchMode.SELECT)
    Set<Electives> electives;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "courses",cascade = CascadeType.ALL)
    @Fetch(value=FetchMode.SELECT)
    Set<Teach> teach;
}
