package com.kivanccode.schoolmanagement.services;

import com.kivanccode.schoolmanagement.models.Courses;
import com.kivanccode.schoolmanagement.models.Students;
import com.kivanccode.schoolmanagement.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;
    //List all students
    public Iterable<Students> list(){

        return studentsRepository.findAll();
    }
    //saves student to database
    public void save(Students student){

        studentsRepository.save(student);
    }
    //if student exists deletes by name
    @Transactional
    public void isDeleteSuccesful(String title){

        studentsRepository.deleteStudents(title);
    }
    //if student exists deletes by id
    @Transactional
    public void isIdDeleteSuccesful(Integer id){

        studentsRepository.deleteStudentsId(id);
    }
    //checks students is exist by id
    public boolean isExistById(Integer id){
        Optional<Students> stu = studentsRepository.findById(id);

        return stu.isPresent();
    }
    //checks students is exits by name if exits returns true
    public boolean isExistByName(String name) {

        List<Students> students = studentsRepository.findAll();

        for (int i = 0; i < students.size(); i++) {
                try {
                    if (students.get(i).getStudentName().equals(name)) {
                        return true;
                    }
                } catch (NullPointerException e) {
                    continue;
                }
        }
        return false;
    }
}

