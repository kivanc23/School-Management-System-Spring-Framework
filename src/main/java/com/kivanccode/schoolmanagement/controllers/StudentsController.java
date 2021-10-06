package com.kivanccode.schoolmanagement.controllers;

import com.kivanccode.schoolmanagement.models.Courses;
import com.kivanccode.schoolmanagement.models.Students;
import com.kivanccode.schoolmanagement.repositories.StudentsRepository;
import com.kivanccode.schoolmanagement.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    //list all students
    @GetMapping("/students")
    public Iterable<Students> list(){

        return studentsService.list();

    }

    //add student to database
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    })
    public ResponseEntity<Students> addNew(@RequestBody Students student){
        Students students = new Students();
        students.setStudentNumber(student.getStudentNumber());
        students.setStudentName(student.getStudentName());
        students.setAdmissionYear(student.getAdmissionYear());
        students.setCollageName(student.getCollageName());
        students.setClassName(student.getClassName());
        students.setBirthDate(student.getBirthDate());
        students.setHomeAdress(student.getHomeAdress());
        students.setMobilePhone(student.getMobilePhone());
        students.setEmail(student.getEmail());
        studentsService.save(students);
        return new ResponseEntity<Students>(students, HttpStatus.OK);
    }
    //delete students by name
    @PostMapping("/student/delete/{name}")
    public void deleteByName(@PathVariable String name){

        if(studentsService.isExistByName(name) == false){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such a student !!");
        }
        else {
            studentsService.isDeleteSuccesful(name);
        }
    }

    //delete students by id
    @PostMapping("/student/deleteid/{id}")
    public void deleteById(@PathVariable Integer id){

        if(studentsService.isExistById(id) == false){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such a student !!");
        }
        else {
            studentsService.isIdDeleteSuccesful(id);
        }
    }


}
