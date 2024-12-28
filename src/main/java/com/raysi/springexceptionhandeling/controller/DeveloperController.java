package com.raysi.springexceptionhandeling.controller;

import com.raysi.springexceptionhandeling.enitity.Developer;
import com.raysi.springexceptionhandeling.exception.BussinessException;
import com.raysi.springexceptionhandeling.exception.ControllerException;
import com.raysi.springexceptionhandeling.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService){
        this.developerService = developerService;
    }

    @GetMapping("/api/dev")
    public ResponseEntity<List<Developer>> fetchAllData(){
        List<Developer> developers = developerService.getDevelopers();
        if(developers.isEmpty()){
            throw new BussinessException("701", "No data availabe");
        }
        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

    @GetMapping("/api/dev/{id}")
    public ResponseEntity<Developer> fetchDeveloperById(@PathVariable Long id){
        Developer developer = developerService.getDeveloper(id);
        if (developer.)
    }
}
