package controller;


import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import exceptions.UserNotFoundException;
import model.PostBean;
import model.UserBean;
import repository.UserRepository;
import service.PostService;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class PostController {

    @Autowired
    private UserRepository userRepository ;



    
    @Autowired
    private PostService post;
	
	
	@RequestMapping(value="/Posts", method=RequestMethod.GET)
    public List<PostBean> listPosts() {
		return post.listPosts();
    }
	
	
	
	
	  @GetMapping(value ="/Posts/{id}")
	  public Optional<PostBean> listPostById(@PathVariable int id) {
		 
		  return post.listPostById(id);

		  
		  
	  }
	
	  
	
	  
	  @GetMapping(value = "/Posts/keywords/{recherche}")
	    public List<PostBean> testeDeRequetes(@PathVariable String recherche) {
	        return post.testeDeRequetes(recherche);
	    }
  
	  
	  
	  
	//ajouter un post
	  @PutMapping (value = "/Posts")
	    public ResponseEntity<Void> AddUser(@RequestBody PostBean postt) {
		  Optional<UserBean> p = userRepository.findById(postt.getIdUser());

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
	        
	        
	        PostBean postAdded =  post.AddUser(postt);

	        if (postAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(postAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	    }

	
	  
	  @DeleteMapping (value = "/Posts/{id}")
	   public void supprimerProduit(@PathVariable int id) {
		  post.supprimerProduit(id);
	   }
	  

	  @PostMapping(value = "/Posts")
	    public ResponseEntity<Void> AddUserpos(@RequestBody PostBean postt) {

		  Optional<UserBean> p = userRepository.findById(postt.getIdUser());

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
	        
	        
	        PostBean postAdded =  post.AddUserpos(postt);

	        if (postAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(postAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	    }
    
    
    
	
}
