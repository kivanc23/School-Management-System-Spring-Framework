package com.kivanccode.schoolmanagement.controllers;

import ch.qos.logback.core.CoreConstants;
import com.kivanccode.schoolmanagement.models.Courses;
import com.kivanccode.schoolmanagement.models.Teachers;
import com.kivanccode.schoolmanagement.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    //list all courses
    @GetMapping("/courses")
    public Iterable<Courses> list(){

        return coursesService.list();

    }
    //pull course from database with id
    @RequestMapping("/course/{id}")
    public Optional<Courses> findById(@PathVariable Integer id) {

        if(coursesService.isExistByUserId(id) == false){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such a class !!");
        }
        else {
            return coursesService.findById(id);
        }
    }

    //add course to database
    @RequestMapping(value = "/course",method = RequestMethod.POST)
    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
    })
    public ResponseEntity<Courses> addNew(@RequestBody Courses course){
        Courses courses = new Courses();
        courses.setCourseName(course.getCourseName());
        courses.setCourseNumber(course.getCourseNumber());
        courses.setCourseNature(course.getCourseNature());
        courses.setTheoreticalHours(course.getTheoreticalHours());
        courses.setCourseDescription(course.getCourseDescription());
        courses.setCourseCredit(course.getCourseCredit());
        courses.setExperimentHours(course.getExperimentHours());
        courses.setOpenSemester(course.getOpenSemester());
        coursesService.save(courses);
        return new ResponseEntity<Courses>(courses, HttpStatus.OK);
    }

    //delete courses by name
    @PostMapping("/course/delete/{name}")
    public void deleteByName(@PathVariable String name){

        coursesService.isDeleteSuccesful(name);

    }

}
