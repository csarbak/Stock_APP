package com.wiley.schoolJPA.dao;

import com.wiley.schoolJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
