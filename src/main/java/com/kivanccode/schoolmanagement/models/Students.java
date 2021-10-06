package com.kivanccode.schoolmanagement.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentNumber")
    private Integer StudentNumber;

    private String StudentName;

    private char AdmissionYear;

    private String CollageName;

    private String ClassName;

    private Integer BirthDate;

    private String HomeAdress;

    private String MobilePhone;

    private String Email;

    public Students(Integer studentNumber, String studentName, char admissionYear, String collageName, String className, Integer birthDate, String homeAdress, String mobilePhone, String email) {
        StudentNumber = studentNumber;
        StudentName = studentName;
        AdmissionYear = admissionYear;
        CollageName = collageName;
        ClassName = className;
        BirthDate = birthDate;
        HomeAdress = homeAdress;
        MobilePhone = mobilePhone;
        Email = email;
    }

//    @ManyToMany(mappedBy = "Electives")
//    Set<Courses> Course;

    @OneToMany(mappedBy = "student")
    Set<Electives> electives;
}
