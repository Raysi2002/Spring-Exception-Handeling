package com.raysi.springexceptionhandeling.service;

import com.raysi.springexceptionhandeling.enitity.Developer;
import com.raysi.springexceptionhandeling.exception.BussinessException;
import com.raysi.springexceptionhandeling.exception.ControllerException;
import com.raysi.springexceptionhandeling.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeveloperServiceImplementation implements DeveloperService{

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImplementation(DeveloperRepository developerRepository){
        this.developerRepository = developerRepository;
    }

    @Override
    public List<Developer> getDevelopers() {
        try{
            List<Developer> developers = developerRepository.findAll();
            if(developers.isEmpty()){
                throw new BussinessException("701", "No data available");
            }
            return developers;
        }catch (Exception e){
            throw new BussinessException("702", "Something went wrong");
        }
    }

    @Override
    public Developer getDeveloper(Long id) {
        return developerRepository.findById(id).orElseThrow(BussinessException :: new);
    }

    @Override
    public void saveDeveloper(Developer developer) {

    }

    @Override
    public void saveDevelopers(List<Developer> developers) {

    }

    @Override
    public void deleteDeveloper(Long id) {

    }

    @Override
    public void updateDeveloper(Long id, Developer developer) {

    }
}
