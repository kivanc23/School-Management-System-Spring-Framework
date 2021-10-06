package com.kivanccode.schoolmanagement.controllers;

import com.kivanccode.schoolmanagement.services.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class TeachController {
    @Autowired
    TeachService teachService;

    //delete teach by id
    @PostMapping("/teach/deleteid/{id}")
    public void deleteById(@PathVariable Integer id){

        if(teachService.isExistById(id) == false){
            throw new ResponseStatusException(NOT_FOUND, "There is no such a teach !!");
        }
        else {
            teachService.isIdDeleteSuccesful(id);
        }
    }
}
