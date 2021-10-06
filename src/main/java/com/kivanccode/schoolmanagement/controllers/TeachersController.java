package com.kivanccode.schoolmanagement.controllers;

import com.kivanccode.schoolmanagement.models.Courses;
import com.kivanccode.schoolmanagement.models.Students;
import com.kivanccode.schoolmanagement.models.Teach;
import com.kivanccode.schoolmanagement.models.Teachers;
import com.kivanccode.schoolmanagement.repositories.CoursesRepository;
import com.kivanccode.schoolmanagement.repositories.TeachRepository;
import com.kivanccode.schoolmanagement.repositories.TeachersRepository;
import com.kivanccode.schoolmanagement.services.CoursesService;
import com.kivanccode.schoolmanagement.services.TeachService;
import com.kivanccode.schoolmanagement.services.TeachersService;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class TeachersController {
    @Autowired
    TeachersService teachersService;
    @Autowired
    TeachersRepository teachersRepository;
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    TeachService teachService;
    @Autowired
    CoursesService coursesService;
    @Autowired
    TeachRepository teachRepository;
    //list all teachers normally
    @GetMapping("/teachers")
    public Iterable<Teachers> list(){

        return teachersService.list();
    }

    //add teachers to database
    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    })
    public ResponseEntity<Teachers> addNew(@RequestBody Teachers teacher){
        Teachers teachers = new Teachers();
        teachers.setTeacherNumber(teacher.getTeacherNumber());
        teachers.setTeacherName(teacher.getTeacherName());
        teachers.setGraduationSchool(teacher.getGraduationSchool());
        teachers.setGraduationDate(teacher.getGraduationDate());
        teachers.setTechnicalTitle(teacher.getTechnicalTitle());
        teachers.setFinalDegree(teacher.getFinalDegree());
        teachers.setMobilePhone(teacher.getMobilePhone());
        teachers.setElectronicMailbox(teacher.getElectronicMailbox());
        teachersService.save(teachers);
        return new ResponseEntity<Teachers>(teachers, HttpStatus.OK);
    }
    //delete teachers by id
    @PostMapping("/teacher/deleteid/{id}")
    public void deleteById(@PathVariable Integer id){

        if(teachersService.isExistById(id) == false){
            throw new ResponseStatusException(NOT_FOUND, "There is no such a student !!");
        }
        else {
            teachersService.isIdDeleteSuccesful(id);
        }
    }

    //adding course to teacher with help of url
    @RequestMapping(value = "/teachers/teach/{teacherId}/{courseId}", method = RequestMethod.POST)
    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    })
    public void addNewTeach(@PathVariable Integer teacherId,@PathVariable Integer courseId){

        if(teachersService.isExistById(teacherId) != true){
            throw new ResponseStatusException(NOT_FOUND, "Unable to find Teacher");
        }
        else if(coursesService.isExistById(courseId) != true){
            throw new ResponseStatusException(NOT_FOUND, "Unable to find Course");
        }
        else {
            Teachers teacher = teachersRepository.getTeacherById(teacherId);
            Courses course = coursesRepository.getCourseById(courseId);

            try {
                if(teachRepository.getTeachCourseNumber(courseId) == courseId && teachRepository.getTeachTeacherNumber(teacherId) == teacherId){
                    throw new ResponseStatusException(BAD_REQUEST, "Already added this Teach.");
                }
            }catch (AopInvocationException e){
                Teach teach = new Teach(1,course,teacher);
                teachService.save(teach);
            }
        }
    }
}
