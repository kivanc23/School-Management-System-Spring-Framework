package com.kivanccode.schoolmanagement.services;

import com.kivanccode.schoolmanagement.models.Teach;
import com.kivanccode.schoolmanagement.models.Teachers;
import com.kivanccode.schoolmanagement.repositories.TeachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeachService {
    @Autowired
    TeachRepository teachRepository;

    //Save teach to database
    public void save(Teach teach){
        teachRepository.save(teach);
    }
    //check teach is exist by id
    public boolean isExistById(Integer id){
        Optional<Teach> the = teachRepository.findById(id);

        return the.isPresent();
    }
    //if teach exists deletes by id
    @Transactional
    public void isIdDeleteSuccesful(Integer id){

        teachRepository.deleteTeachId(id);
    }
}
