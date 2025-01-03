package com.raysi.springexceptionhandeling.controller;

import com.raysi.springexceptionhandeling.enitity.Developer;
import com.raysi.springexceptionhandeling.exception.BussinessException;
import com.raysi.springexceptionhandeling.exception.ResourcesNotFoundException;
import com.raysi.springexceptionhandeling.service.DeveloperService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Developer developer = developerService.getDeveloper(id)
                .orElseThrow(() -> new ResourcesNotFoundException("901", "Resource Not Found"));
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("901", "Dev Not Found")
                .body(developer);

    }

    @PostMapping("/api/dev")
    public ResponseEntity<?> saveData(@RequestBody Developer developer){
        developerService.saveDeveloper(developer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Accept-Datetime")
                .body(developer);
    }
}
