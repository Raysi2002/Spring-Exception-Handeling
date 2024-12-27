package com.raysi.springexceptionhandeling.service;

import com.raysi.springexceptionhandeling.enitity.Developer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {
    List<Developer>  getDevelopers();
    Developer getDeveloper(Long id);
    void saveDeveloper(Developer developer);
    void saveDevelopers(List<Developer> developers);
    void deleteDeveloper(Long id);
    void updateDeveloper(Long id, Developer developer);
}