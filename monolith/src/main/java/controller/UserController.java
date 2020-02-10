package controller;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;


import repository.UserRepository;
import service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import exceptions.UserNotFoundException;
import model.UserBean;

@RestController
@RequestMapping(value = "/")
public class UserController {

	@Autowired
    private UserService userDao;
	
	
	@RequestMapping(value="/Users", method=RequestMethod.GET)
    public List<UserBean> listUsers() {
		return userDao.listUsers();
    }
	
	
	
	
	  @GetMapping(value ="/Users/{id}")
	  public Optional<UserBean> listUserById(@PathVariable int id) {
		  
		  Optional<UserBean> p = userDao.listUserById(id);

	        return p;

		
	  }
	
	  
	  @GetMapping(value = "/Users/age/{ageLimit}")
	  public List<UserBean> testeDePrix(@PathVariable int ageLimit) {
	      return userDao.testeDePrix(ageLimit);
	  }
	  
	  
	  @GetMapping(value = "/Users/names/{recherche}")
	    public List<UserBean> testeDeRequetes(@PathVariable String recherche) {
	        return userDao.testeDeRequetes("%"+recherche+"%");
	    }
  
	//ajouter un produit
	  @PutMapping (value = "/Users")
	    public ResponseEntity<Void> AddUser(@RequestBody UserBean user) {

		return  userDao.AddUser(user);
	    }

	
	  
	  @DeleteMapping (value = "/Users/{id}")
	   public void supprimerProduit(@PathVariable int id) {
		  userDao.supprimerProduit(id);
	   }
	  

	  @PostMapping(value = "/Users")
	  @CrossOrigin(origins="http://localhost:9094")
	  public ResponseEntity<Void> AddUserpos(@RequestBody UserBean user) {

		  	return userDao.AddUserpos(user);
	    }
}
