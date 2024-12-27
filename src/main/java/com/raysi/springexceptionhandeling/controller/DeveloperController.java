package com.raysi.springexceptionhandeling.controller;

import com.raysi.springexceptionhandeling.enitity.Developer;
import com.raysi.springexceptionhandeling.exception.BussinessException;
import com.raysi.springexceptionhandeling.exception.ControllerException;
import com.raysi.springexceptionhandeling.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        try{
            List<Developer> devs =  developerService.getDevelopers();
            if (devs.isEmpty()){
                throw new BussinessException("701", "No data available");
            }
            return new ResponseEntity<>(devs, HttpStatus.OK);
        }catch (Exception e){
            throw new ControllerException("801", "Something went wrong in controller level");
        }
    }
}
