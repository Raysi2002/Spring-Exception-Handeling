package com.raysi.springexceptionhandeling.repository;

import com.raysi.springexceptionhandeling.enitity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
