package com.Post.Post;

import com.Post.Post.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.Post.Post.MicroserviceUserProxy;


import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Controller {

    @Autowired
    private MicroserviceUserProxy UserProxy;

  /*
    @RequestMapping(value="/Posts" , method=RequestMethod.GET)
    public List<UserBean> ListPosts(){

        List<UserBean> users =  UserProxy.listUsers();
*/

    
    @Autowired
    private PostRepository post;
	
	
	@RequestMapping(value="/Posts", method=RequestMethod.GET)
    public List<PostBean> listPosts() {
		return post.findAll();
    }
	
	
	
	
	  @GetMapping(value ="/Posts/{id}")
	  public Optional<PostBean> listPostById(@PathVariable int id) {
		 
		  Optional<PostBean> p = post.findById(id);

	        if (!p.isPresent()) {throw new PostNotFoundException("Post not found");}

	        return p;

		  
		  
	  }
	
	  
	
	  
	  @GetMapping(value = "/Posts/keywords/{recherche}")
	    public List<PostBean> testeDeRequetes(@PathVariable String recherche) {
	        return post.findByPosttLike("%"+recherche+"%");
	    }
  
	//ajouter un post
	  @PutMapping (value = "/Posts")
	    public ResponseEntity<Void> AddUser(@RequestBody PostBean postt) {
		  Optional<UserBean> p = UserProxy.listUserById(postt.getIdUser());

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
	        
	        
	        PostBean postAdded =  post.save(postt);

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
		  Optional<PostBean> p = post.findById(id);

	        if (!p.isPresent()) {throw new PostNotFoundException("Post not found");}
	        post.deleteById(id);
	   }
	  

	  @PostMapping(value = "/Posts")
	    public ResponseEntity<Void> AddUserpos(@RequestBody PostBean postt) {

		    Optional<UserBean> p = UserProxy.listUserById(postt.getIdUser());

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
		  
		   PostBean postAdded =  post.save(postt);

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
