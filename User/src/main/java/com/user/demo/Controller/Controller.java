package com.user.demo.Controller;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;


import com.user.demo.repository.UserDAO;

import Exceptions.UserNotFoundException;


import com.user.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class Controller {

	@Autowired
    private UserDAO userDao;
	
	
	@RequestMapping(value="/Users", method=RequestMethod.GET)
    public List<User> listUsers() {
		return userDao.findAll();
    }
	
	
	
	
	  @GetMapping(value ="/Users/{id}")
	  public Optional<User> listUserById(@PathVariable int id) {
		  
		  Optional<User> p = userDao.findById(id);

	        return p;

		
	  }
	
	  
	  @GetMapping(value = "/Users/age/{ageLimit}")
	  public List<User> testeDePrix(@PathVariable int ageLimit) {
	      return userDao.findByAgeGreaterThan(ageLimit);
	  }
	  
	  
	  @GetMapping(value = "/Users/names/{recherche}")
	    public List<User> testeDeRequetes(@PathVariable String recherche) {
	        return userDao.findByNameLike("%"+recherche+"%");
	    }
  
	//ajouter un produit
	  @PutMapping (value = "/Users")
	    public ResponseEntity<Void> AddUser(@RequestBody User user) {

	        User userAdded =  userDao.save(user);

	        if (userAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(userAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	    }

	
	  
	  @DeleteMapping (value = "/Users/{id}")
	   public void supprimerProduit(@PathVariable int id) {
		  Optional<User> p = userDao.findById(id);

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
	       userDao.deleteById(id);
	   }
	  

	  @PostMapping(value = "/Users")
	  @CrossOrigin(origins="http://localhost:9094")
	  public ResponseEntity<Void> AddUserpos(@RequestBody User user) {

	        User userAdded =  userDao.save(user);

	        if (userAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(userAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	    }
}
