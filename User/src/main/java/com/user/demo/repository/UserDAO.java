package com.user.demo.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import  com.user.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

	    public List<User>findAll();
	    public Optional<User> findById(int id);
	    public User save(User user);
	    public List<User> findByAgeGreaterThan(int age);
	    public List<User> findByNameLike(String recherche);

	    public void deleteById(int id);
	
}
