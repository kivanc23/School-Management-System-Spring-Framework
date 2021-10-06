package com.kivanccode.schoolmanagement.services;

import com.kivanccode.schoolmanagement.models.Teachers;
import com.kivanccode.schoolmanagement.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeachersService {
    @Autowired
    TeachersRepository teachersRepository;

    //List all teachers
    public Iterable<Teachers> list(){

        return teachersRepository.findAll();
    }
    //saves teacher to database
    public void save(Teachers teacher){

        teachersRepository.save(teacher);
    }
    //if teacher exists deletes by id
    @Transactional
    public void isIdDeleteSuccesful(Integer id){

        teachersRepository.deleteTeachersId(id);
    }
    //check teacher is exist by id
    public boolean isExistById(Integer id){
        Optional<Teachers> the = teachersRepository.findById(id);

        return the.isPresent();
    }
}
