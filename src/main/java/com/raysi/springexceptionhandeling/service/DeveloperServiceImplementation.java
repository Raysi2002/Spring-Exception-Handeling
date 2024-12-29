package com.raysi.springexceptionhandeling.service;

import com.raysi.springexceptionhandeling.enitity.Developer;
import com.raysi.springexceptionhandeling.exception.BussinessException;
import com.raysi.springexceptionhandeling.exception.ControllerException;
import com.raysi.springexceptionhandeling.exception.ResourcesNotFoundException;
import com.raysi.springexceptionhandeling.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public Optional<Developer> getDeveloper(Long id) {
        try{
            return developerRepository.findById(id);
        }catch (ResourcesNotFoundException e){
            throw new ResourcesNotFoundException("701", "The developer with id : " + id + " doesn't exists");
        }catch (Exception e){
            System.out.println("Some error occurred in Service Layer, Please Try Again !");
        }
        return Optional.empty();
    }

    @Override
    public void saveDeveloper(Developer developer) {
        if (developer.getName().equalsIgnoreCase("")){
            throw new BussinessException("1001", "The data can't be empty");
        }
        try {
            developerRepository.save(developer);
        }catch (Exception e){
            throw new BussinessException("1001", "Something went wrong in service layer");
        }
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
