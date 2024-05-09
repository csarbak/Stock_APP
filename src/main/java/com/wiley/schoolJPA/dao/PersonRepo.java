package com.wiley.schoolJPA.dao;

import com.wiley.schoolJPA.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}
