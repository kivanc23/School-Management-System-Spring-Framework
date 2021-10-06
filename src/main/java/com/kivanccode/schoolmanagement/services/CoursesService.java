package com.kivanccode.schoolmanagement.services;

import com.kivanccode.schoolmanagement.models.Courses;
import com.kivanccode.schoolmanagement.models.Teachers;
import com.kivanccode.schoolmanagement.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService{
    @Autowired //Injection
    private CoursesRepository coursesRepository;

    //List all courses
    public Iterable<Courses> list(){

        return coursesRepository.findAll();
    }
    //find courses by id
    public Optional<Courses> findById(Integer id){

        return coursesRepository.findById(id);
    }
    //checks course is exists or not
    public boolean isExistByUserId(Integer id){
        Optional<Courses> course = coursesRepository.findById(id);
        return course.isPresent();
    }
    //saves courses to database
    public void save(Courses courses){

        coursesRepository.save(courses);
    }
    //deletes from databases depend on name *this function is not checks course is exists or not exist*
    @Transactional
    public void isDeleteSuccesful(String title){
        coursesRepository.deleteCourses(title);
    }

    public boolean isExistById(Integer id){
        Optional<Courses> the = coursesRepository.findById(id);

        return the.isPresent();
    }


}
